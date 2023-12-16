package unifr.project.behaviors;

import unifr.project.MqttHandler;

/**
 * Abstract class of the behaviours of the car
 */
public abstract class VehicleBehaviours implements Runnable {
    MqttHandler mqttHandler;
    String vehicleId;

    public VehicleBehaviours createNewInstance(MqttHandler mqttHandler, String vehicleId) {
        return null;
    }

    @Override
    public void run(){}
}
