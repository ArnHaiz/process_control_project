package unifr.project.behaviors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.paho.client.mqttv3.MqttException;
import unifr.project.Delay;
import unifr.project.MqttHandler;

/**
 * Class handling a simple driving style for a car with id <span>vehicleId</span>
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class VehicleDriver extends VehicleBehaviours {
    MqttHandler mqttHandler;
    String vehicleId;

    /**
     * Public constructor of the class
     * @param mqttHandler the client offering the connection to the mqtt server
     * @param vehicleId the id of the car we are handling
     */
    public VehicleDriver(MqttHandler mqttHandler, String vehicleId) {
        this.mqttHandler = mqttHandler;
        this.vehicleId = vehicleId;
    }

    @Override
    public VehicleDriver createNewInstance(MqttHandler mqttHandler, String vehicleId) {
        return new VehicleDriver(mqttHandler, vehicleId);
    }

    @Override
    public void run() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode payload = objectMapper.createObjectNode();
        payload.put("type", "speed");

        try {
            System.out.println("speeeeeeeeeeeeeed");

            while (true) {
                payload.putObject("payload").put("velocity", 400).put("acceleration", 500);
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
                Thread.sleep(5000);

                payload.putObject("payload").put("velocity", 200).put("acceleration", 300);
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
                Thread.sleep(5000);
            }
        } catch (InterruptedException | MqttException e) {
            try {
                payload.putObject("payload").put("velocity", 0).put("acceleration", 300);
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
            } catch (MqttException ex) {
                ex.printStackTrace();
            }
            System.out.println("Thread running the driving for car " + vehicleId + "has been interrupted");
        }
    }
}
