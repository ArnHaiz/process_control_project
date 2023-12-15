package unifr.project.behaviors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import unifr.project.MqttHandler;

/**
 * Class handling the connection of the car with id <span>vehicleId</span> to the mqtt broker.
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class VehicleDiscover extends VehicleBehaviours {
    private MqttHandler mqttHandler;
    private String vehicleId;

    /**
     * Public constructor of the class
     * @param mqttHandler the client offering the connection to the mqtt server
     * @param vehicleId the id of the car we are handling
     */
    public VehicleDiscover(MqttHandler mqttHandler, String vehicleId) {
        this.mqttHandler = mqttHandler;
        this.vehicleId = vehicleId;
    }

    @Override
    public void run() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode payloadDiscover = objectMapper.createObjectNode();
            payloadDiscover.put("type", "discover");
            payloadDiscover.putObject("payload").put("value", "true");
            mqttHandler.publish("Anki/Hosts/U/hyperdrive/I", payloadDiscover.toString());

            ObjectNode payloadConnect = objectMapper.createObjectNode();
            payloadConnect.put("type", "connect");
            payloadConnect.putObject("payload").put("value", "true");
            mqttHandler.publish("Anki/Vehicles/U/" + vehicleId + "/I", payloadConnect.toString());

            payloadDiscover.putObject("payload").put("value", "false");
            mqttHandler.publish("Anki/Hosts/U/hyperdrive/I", payloadDiscover.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
