package unifr.project.behaviors;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import unifr.project.MessageListener;
import unifr.project.MqttHandler;

public abstract class VehicleBehaviours implements Runnable {
    MqttHandler mqttHandler;
    String vehicleId;

    @Override
    public void run(){}
}
