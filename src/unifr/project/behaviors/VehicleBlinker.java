package unifr.project.behaviors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import unifr.project.MqttHandler;

/**
 * Class handling the blinking of a vehicle with id <span>vehicleId</span>
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class VehicleBlinker extends VehicleBehaviours {
    MqttHandler mqttHandler;
    String vehicleId;

    public VehicleBlinker(MqttHandler mqttHandler, String vehicleId) {
        this.mqttHandler = mqttHandler;
        this.vehicleId = vehicleId;
    }

    @Override
    public void run() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode payload = objectMapper.createObjectNode();
            payload.put("type", "lights");

            while(true) {
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
            e.printStackTrace();
        }
    }
}
