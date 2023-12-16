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
    static boolean isInEmergency = false;
    static boolean hasSetEmergencyState = false;

    private final static int EMERGENCY_STOP_KEY = 's';
    private final static int EMERGENCY_RESTART_KEY = 'r';

    private static ArrayList<Thread> threads = new ArrayList<>();

    private static VehicleBlinker vehicleBlinker;
    private static VehicleDriver vehicleDriver;
    private static VehicleLaneChange vehicleLaneChange;
    private static TrackIdSubscription trackIdSubscription;

    private static Thread blinkThread;
    private static Thread driverThread;
    private static Thread laneChangeThread;
    private static Thread trackIdThread;

    public static void main(String[] args) {
        try {
            MqttHandler mqttHandler = new MqttHandler("tcp://192.168.4.1:1883", "PredictionGroups");

            VehicleDiscover vehicleDiscover = new VehicleDiscover(mqttHandler, vehicleId);
            Thread discoverThread = new Thread(vehicleDiscover);
            discoverThread.start();

            vehicleBlinker = new VehicleBlinker(mqttHandler, vehicleId);
            blinkThread = new Thread(vehicleBlinker);
            threads.add(blinkThread);

            vehicleDriver = new VehicleDriver(mqttHandler, vehicleId);
            driverThread = new Thread(vehicleDriver);
            threads.add(driverThread);

            vehicleLaneChange = new VehicleLaneChange(mqttHandler, vehicleId);
            laneChangeThread = new Thread(vehicleLaneChange);
            threads.add(laneChangeThread);

            trackIdSubscription = new TrackIdSubscription(mqttHandler, vehicleId);
            trackIdThread = new Thread(trackIdSubscription);
            threads.add(trackIdThread);

            for (Thread thread : threads) thread.start();

            mqttHandler.subscribe("Anki/Hosts/predictionGroup/S/EmergencyStatus");

            while (true) {
                if (isInEmergency && !hasSetEmergencyState) getInEmergency(mqttHandler, threads);

                int readVal = System.in.read();
                if (readVal == EMERGENCY_STOP_KEY) {
                    getInEmergency(mqttHandler, threads);
                } else if (readVal == EMERGENCY_RESTART_KEY) {
                    getOutOfEmergency(mqttHandler, threads);
                }
            }

        } catch (IOException | MqttException e) {
            e.printStackTrace();
        }
    }

    public static void getInEmergency(MqttHandler mqttHandler, ArrayList<Thread> threads) throws MqttException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode emergencyPayload = objectMapper.createObjectNode();

        emergencyPayload.put("isInEmergency", "true");
        mqttHandler.publish("Anki/Hosts/predictionGroup/s/EmergencyStatus", emergencyPayload.toString());

        for (Thread thread : threads) thread.interrupt();

        System.out.println("Emergency mode engaged");
    }

    public static void getOutOfEmergency(MqttHandler mqttHandler, ArrayList<Thread> threads) throws MqttException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode emergencyPayload = objectMapper.createObjectNode();

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
