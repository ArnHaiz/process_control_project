package unifr.project;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.paho.client.mqttv3.MqttException;

import unifr.project.behaviors.*;

/**
 * Main class of this subsection of the project managing the connection, control and status of the car with id <span>vehicleId</span> on different threads
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class Main {

    static String vehicleId = "d11d2fea5c74"; //id of the car we are working on, has to be defined by hand
    static Boolean isInEmergency = false;
    private final static int EMERGENCY_STOP_KEY = 's';
    private final static int EMERGENCY_RESTART_KEY = 'r';
    private final static ArrayList<VehicleBehaviours> vehicleBehaviours = new ArrayList<>();
    private final static ArrayList<Thread> threads = new ArrayList<>();
    private static boolean hasTerminatedThreads = false;

    public static void main(String[] args) {
        try {
            MqttHandler mqttHandler = new MqttHandler("tcp://192.168.4.1:1883", "PredictionGroups");

            VehicleBlinker vehicleBlinker = new VehicleBlinker(mqttHandler, vehicleId);
            Thread blinkThread = new Thread(vehicleBlinker);
            threads.add(blinkThread);

            VehicleDriver vehicleDriver = new VehicleDriver(mqttHandler, vehicleId);
            Thread driverThread = new Thread(vehicleDriver);
            vehicleBehaviours.add(vehicleDriver);
            threads.add(driverThread);

            VehicleLaneChange vehicleLaneChange = new VehicleLaneChange(mqttHandler, vehicleId);
            Thread laneChangeThread = new Thread(vehicleLaneChange);
            vehicleBehaviours.add(vehicleLaneChange);
            threads.add(laneChangeThread);

            TrackIdSubscription trackIdSubscription = new TrackIdSubscription(mqttHandler, vehicleId);
            Thread trackIdThread = new Thread(trackIdSubscription);
            vehicleBehaviours.add(trackIdSubscription);
            threads.add(trackIdThread);

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

            for (Thread thread : threads) thread.start();

            while (true) {
                int readVal = System.in.read();
                if (readVal == -1) {

                } else if (readVal == EMERGENCY_STOP_KEY) {
                    ObjectNode speedPayload = objectMapper.createObjectNode();
                    speedPayload.put("type", "speed");
                    speedPayload.putObject("payload").put("velocity", 0).put("acceleration", 400);

                    payloadEmergency.put("isInEmergency", "true");
                    mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", payloadEmergency.toString());
                    mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", speedPayload.toString());

                    for (Thread thread : threads) {
                        thread.interrupt();
                        threads.remove(thread);
                    }
                    hasTerminatedThreads = true;

                    System.out.println("Emergency mode engaged");
                } else if (readVal == EMERGENCY_RESTART_KEY) {
                    payloadEmergency.put("isInEmergency", "false");
                    mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", payloadEmergency.toString());

                    blinkThread = new Thread(vehicleBlinker);
                    driverThread = new Thread(vehicleDriver);
                    laneChangeThread = new Thread(vehicleLaneChange);
                    trackIdThread = new Thread(trackIdSubscription);
                    threads.add(blinkThread);
                    threads.add(driverThread);
                    threads.add(laneChangeThread);
                    threads.add(trackIdThread);


                    hasTerminatedThreads = false;

                    System.out.println("Emergency mode disengaged");
                } else if (!hasTerminatedThreads){
                    for (Thread thread : threads) thread.interrupt();
                    hasTerminatedThreads = true;
                    break;
                }
            }
        } catch (InterruptedException | IOException | MqttException e) {
            e.printStackTrace();
        }
    }
}
