package unifr.project;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.paho.client.mqttv3.MqttException;

import unifr.project.behaviors.VehicleDriver;
import unifr.project.behaviors.VehicleLaneChange;

/**
 * Main class of this subsection of the project managing the connection, control and status of the car with id <span>vehicleId</span> on different threads
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class Main {

    static String vehicleId = "d205effe02cb"; //id of the car we are working on, has to be defined by hand
    static Boolean isInEmergency = false;
    private final static int EMERGENCY_STOP_KEY = 's';
    private final static int EMERGENCY_RESTART_KEY = 'r';
    private final static ArrayList<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        try {
            MqttHandler mqttHandler = new MqttHandler("tcp://192.168.4.1:1883", "PredictionGroups");

            /*VehicleBlinker vehicleBlinker = new VehicleBlinker(mqttHandler, vehicleId);
            Thread blinkThread = new Thread(vehicleBlinker);
            threads.add(blinkThread);*/

            VehicleDriver vehicleDriver = new VehicleDriver(mqttHandler, vehicleId);
            Thread driverThread = new Thread(vehicleDriver);
            threads.add(driverThread);

            VehicleLaneChange vehicleLaneChange = new VehicleLaneChange(mqttHandler, vehicleId);
            Thread laneChangeThread = new Thread(vehicleLaneChange);
            threads.add(laneChangeThread);

            /*TrackIdSubscription trackIdSubscription = new TrackIdSubscription(mqttHandler, vehicleId);
            Thread trackIdThread = new Thread(trackIdSubscription);
            threads.add(trackIdThread);*/

            EmergencyStop emergencyStop = new EmergencyStop(threads);
            Thread emergencyThread = new Thread(emergencyStop);

            //blinkThread.start();
            driverThread.start();
            laneChangeThread.start();
            //trackIdThread.start();
            emergencyThread.start();

            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode payloadDiscover = objectMapper.createObjectNode();
            payloadDiscover.put("type", "discover");
            payloadDiscover.putObject("payload").put("value", "true");
            mqttHandler.publish("Anki/Hosts/U/hyperdrive/I", payloadDiscover.toString());

            Thread.sleep(100);

            ObjectNode payloadConnect = objectMapper.createObjectNode();
            payloadConnect.put("type", "connect");
            payloadConnect.putObject("payload").put("value", "true");
            mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payloadConnect.toString());

            Thread.sleep(100);

            payloadDiscover.putObject("payload").put("value", "false");
            mqttHandler.publish("Anki/Hosts/U/hyperdrive/I", payloadDiscover.toString());

            ObjectNode payloadEmergency = objectMapper.createObjectNode();
            payloadEmergency.put("isInEmergency", "false");
            mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", payloadEmergency.toString());
            mqttHandler.subscribe("Anki/Hosts/predictionGroup/s/EmergencyStatus");

            int readVal = System.in.read();
            if (readVal == EMERGENCY_STOP_KEY) {
                payloadEmergency.put("isInEmergency", "true");
                mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", payloadEmergency.toString());
                emergencyThread.start();
                System.out.println("Emergency mode engaged");
            } else if (readVal == EMERGENCY_RESTART_KEY) {
                payloadEmergency.put("isInEmergency", "false");
                mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", payloadEmergency.toString());
                emergencyThread.interrupt();
                emergencyThread = new Thread(emergencyStop);
                emergencyThread.start();
                System.out.println("Emergency mode disengaged");
            }else {
                //blinkThread.interrupt();
                driverThread.interrupt();
                laneChangeThread.interrupt();
                vehicleLaneChange.unsubscribe();
                //trackIdSubscription.unsubscribe();
                //trackIdThread.interrupt();
                emergencyThread.interrupt();
            }

        } catch (InterruptedException | IOException | MqttException e) {
            e.printStackTrace();
        }
    }
}
