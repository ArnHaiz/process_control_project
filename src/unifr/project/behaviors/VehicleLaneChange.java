package unifr.project.behaviors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.paho.client.mqttv3.MqttException;
import unifr.project.MqttHandler;

import java.util.Random;

/**
 * Class handling the change of lane of the car with id <span>vehicleId</span>
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class VehicleLaneChange extends VehicleBehaviours {
    MqttHandler mqttHandler;
    String vehicleId;

    int[] possibleOffsets = {-10, 10}; //the offsets to turn left and right respectively
    Random random = new Random();

    /**
     * Public constructor of the class
     * @param mqttHandler the client offering the connection to the mqtt server
     * @param vehicleId the id of the car we are handling
     */
    public VehicleLaneChange(MqttHandler mqttHandler, String vehicleId) {
        this.mqttHandler = mqttHandler;
        this.vehicleId = vehicleId;
    }

    @Override
    public VehicleLaneChange createNewInstance(MqttHandler mqttHandler, String vehicleId) {
        return new VehicleLaneChange(mqttHandler, vehicleId);
    }

    @Override
    public void run() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode payload = objectMapper.createObjectNode();
        payload.put("type", "lane");

        try {
            while (true) {
                int rdm = random.nextInt(0, 2);
                System.out.println("new lane change try");
                payload.putObject("payload").put("offset", possibleOffsets[rdm])
                        .put("velocity", 300).put("acceleration", "400");
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
                Thread.sleep(5000);
            }

        } catch (InterruptedException e) {
            try {
                mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payload.toString());
            } catch (MqttException ex) {
                ex.printStackTrace();
            }
            payload.putObject("payload").put("offset", 0)
                        .put("velocity", 0).put("acceleration", 400);
            System.out.println("Thread running the lane changing for car " + vehicleId + "has been interrupted");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
