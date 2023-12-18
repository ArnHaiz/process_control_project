package unifr.gui;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.eclipse.paho.client.mqttv3.MqttException;
import unifr.project.MqttHandler;

public class CarStatus {
    MqttHandler mqttHandler;
    String vehicleId;

    String sStatusTopic; //interesting infos there : battery, onTrack
    String eStatusTopic; //interesting infos there : speed, laneOffset, track, lineDrift, laneChange, wheelDistance, intersection

    StackPane stackPane;

    public CarStatus(MqttHandler mqttHandler, String vehicleId) throws MqttException {
        this.mqttHandler = mqttHandler;
        this.vehicleId = vehicleId;

        sStatusTopic = "Anki/Vehicles/U/" + vehicleId + "/s";
        eStatusTopic = "Anki/Vehicles/U/" + vehicleId + "/E";

        mqttHandler.subscribe(sStatusTopic);
        mqttHandler.subscribe(eStatusTopic);

        stackPane = new StackPane();
    }

    public Pane pane() {
        return stackPane;
    }
}
