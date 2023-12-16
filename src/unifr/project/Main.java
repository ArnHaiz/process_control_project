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

    static String vehicleId = "d205effe02cb"; //id of the car we are working on, has to be defined by hand
    static Boolean isInEmergency = false;
    private final static int EMERGENCY_STOP_KEY = 's';
    private final static int EMERGENCY_RESTART_KEY = 'r';
    private static ArrayList<Thread> threads = new ArrayList<>();
    private final static ArrayList<VehicleBehaviours> vehicleBehaviours = new ArrayList<>();

    public static void main(String[] args) {
        try {
            MqttHandler mqttHandler = new MqttHandler("tcp://192.168.4.1:1883", "PredictionGroups");

            VehicleDiscover vehicleDiscover = new VehicleDiscover(mqttHandler, vehicleId);
            Thread discoverThread = new Thread(vehicleDiscover);
            discoverThread.start();

            VehicleBlinker vehicleBlinker = new VehicleBlinker(mqttHandler, vehicleId);
            Thread blinkThread = new Thread(vehicleBlinker);
            threads.add(blinkThread);

            VehicleDriver vehicleDriver = new VehicleDriver(mqttHandler, vehicleId);
            Thread driverThread = new Thread(vehicleDriver);
            threads.add(driverThread);

            VehicleLaneChange vehicleLaneChange = new VehicleLaneChange(mqttHandler, vehicleId);
            Thread laneChangeThread = new Thread(vehicleLaneChange);
            threads.add(laneChangeThread);

            TrackIdSubscription trackIdSubscription = new TrackIdSubscription(mqttHandler, vehicleId);
            Thread trackIdThread = new Thread(trackIdSubscription);
            threads.add(trackIdThread);

            for (Thread thread : threads) thread.start();

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode emergencyPayload = objectMapper.createObjectNode();

            mqttHandler.subscribe("Anki/Hosts/predictionGroup/S/EmergencyStatus");

            while (true) {
                int readVal = System.in.read();

                if (readVal == EMERGENCY_STOP_KEY) {
                    emergencyPayload.put("isInEmergency", "true");
                    mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", emergencyPayload.toString());

                    for (Thread thread : threads) {
                        thread.interrupt();
                    }

                    System.out.println("Emergency mode engaged");
                } else if (readVal == EMERGENCY_RESTART_KEY) {
                    emergencyPayload.put("isInEmergency", "false");
                    mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", emergencyPayload.toString());

                    vehicleBlinker = new VehicleBlinker(mqttHandler, vehicleId);
                    vehicleDriver = new VehicleDriver(mqttHandler, vehicleId);
                    vehicleLaneChange = new VehicleLaneChange(mqttHandler, vehicleId);
                    trackIdSubscription = new TrackIdSubscription(mqttHandler, vehicleId);

                    blinkThread = new Thread(vehicleBlinker);
                    driverThread = new Thread(vehicleDriver);
                    laneChangeThread = new Thread(vehicleLaneChange);
                    trackIdThread = new Thread(trackIdSubscription);
                    threads = new ArrayList<>();
                    threads.add(blinkThread);
                    threads.add(driverThread);
                    threads.add(laneChangeThread);
                    threads.add(trackIdThread);

                    for (Thread thread : threads) thread.start();


                    System.out.println("Emergency mode disengaged");
                }
            }
        } catch (IOException | MqttException e) {
            e.printStackTrace();
        }
    }
}
