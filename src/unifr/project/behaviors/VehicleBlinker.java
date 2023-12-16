package unifr.project.behaviors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.paho.client.mqttv3.MqttException;
import unifr.project.MqttHandler;

/**
 * Class handling the blinking of a vehicle with id <span>vehicleId</span>
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class VehicleBlinker extends VehicleBehaviours {
    MqttHandler mqttHandler;
    String vehicleId;

    /**
     * Public constructor of the class
     * @param mqttHandler the client offering the connection to the mqtt server
     * @param vehicleId the id of the car we are handling
     */
    public VehicleBlinker(MqttHandler mqttHandler, String vehicleId) {
        this.mqttHandler = mqttHandler;
        this.vehicleId = vehicleId;
    }

    @Override
    public VehicleBlinker createNewInstance(MqttHandler mqttHandler, String vehicleId) {
        return new VehicleBlinker(mqttHandler, vehicleId);
    }

    @Override
    public void run() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode payload = objectMapper.createObjectNode();
        payload.put("type", "lights");

        try {
            while (true) {
                payload.putObject("payload").put("back", "on");
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
                payload.putObject("payload").put("front", "off");
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
                Thread.sleep(1000);

                payload.putObject("payload").put("back", "off");
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
                payload.putObject("payload").put("front", "on");
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            try {
                payload.putObject("payload").put("back", "off");
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());

                payload.putObject("payload").put("front", "off");
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
            } catch (MqttException ex) {
                ex.printStackTrace();
            }
            System.out.println("Thread running the alternated blinking for car " + vehicleId + "has been interrupted");
        }
    }
}
