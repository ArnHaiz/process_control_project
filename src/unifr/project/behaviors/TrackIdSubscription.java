package unifr.project.behaviors;

import unifr.project.MqttHandler;

/**
 * Class handling the subscription to the track status of the car with id <span>vehicleId</span>
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class TrackIdSubscription extends VehicleBehaviours {
    private MqttHandler mqttHandler;
    String topic;

    /**
     * Public constructor of the class
     * @param mqttHandler the client offering the connection with the cars
     * @param vehicleId the id of the car we are interested in
     */
    public TrackIdSubscription(MqttHandler mqttHandler, String vehicleId) {
        this.mqttHandler = mqttHandler;
        topic = "Anki/Vehicles/U/" + vehicleId + "/E/track";
    }

    /**
     * function unsubscribing from the track topic of the car
     */
    public void unsubscribe() {
        try {
            mqttHandler.unsubscribe(topic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TrackIdSubscription createNewInstance(MqttHandler mqttHandler, String vehicleId) {
        return new TrackIdSubscription(mqttHandler, vehicleId);
    }

    @Override
    public void run() {
        try {
            mqttHandler.subscribe(topic);
        } catch (Exception e) {
            unsubscribe();
            System.out.println("Thread running the subscribing to track's informations for car" + vehicleId + "has been interrupted");
        }
    }
}
