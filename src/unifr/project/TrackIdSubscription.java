package unifr.project;

/**
 * Class handling the subscription to the track status of the car with id <span>vehicleId</span>
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class TrackIdSubscription implements Runnable {
    private MqttHandler mqttHandler;
    String topic;

    public TrackIdSubscription(MqttHandler mqttHandler, String vehicleId) {
        this.mqttHandler = mqttHandler;
        topic = "Anki/Vehicles/U/" + vehicleId + "/E/track";
    }

    @Override
    public void run() {
        try {
            mqttHandler.subscribe(topic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unsubscribe() {
        try {
            mqttHandler.unsubscribe(topic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
