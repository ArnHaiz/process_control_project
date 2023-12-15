package unifr.project.behaviors;

import unifr.project.MqttHandler;

/**
 * Abstract class of the behaviours of the car
 */
public abstract class VehicleBehaviours implements Runnable {
    MqttHandler mqttHandler;
    String vehicleId;

    @Override
    public void run(){}
}
