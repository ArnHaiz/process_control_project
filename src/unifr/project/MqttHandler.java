package unifr.project;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.HashSet;
import java.util.Set;

/**
 * Class handling the mqtt client's publish, subscribe and message reactions
 *
 * @author Arnaud Reto Koenig
 * @author Arnaud Haizmann (20-806-436) (adaptation of the code)
 */
public class MqttHandler {

    private final MqttAsyncClient client;
    private final MqttConnectOptions options;
    private final Set<MessageListener> messageListeners;

    /**
     * public constructor of the class
     * @param broker the server linking the cars to users
     * @param clientId the id of the user
     * @throws MqttException
     */
    public MqttHandler(String broker, String clientId) throws MqttException {
        messageListeners = new HashSet<>();
        client = new MqttAsyncClient(broker, clientId, new MemoryPersistence());
        client.setCallback(new MessageHandler());
        options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        client.connect(options).waitForCompletion();

    }

    /**
     * function that subscribes to topic <span>topic</span>
     * @param topic the topic to subscribe to
     * @throws MqttException
     */
    public void subscribe(String topic) throws MqttException {
        client.subscribe(topic, 1);  // QoS level 1
    }

    /**
     * function that unsubscribes from topic <span>topic</span>
     * @param topic the topic to unsubscribe from
     * @throws MqttException
     */
    public void unsubscribe(String topic) throws MqttException {
        client.unsubscribe(topic);
    }

    /**
     * function that allows publishing to a topic <span>topic</span> with a message <span>message</span>
     * @param topic the topic to publish to
     * @param payload the payload to publish
     * @throws MqttException
     */
    public void publish(String topic, String payload) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        client.publish(topic, message);
    }

    /**
     * function adding a listener to the list of message arrival listeners
     * @param listener the listener to add
     */
    public void addMessageListener(MessageListener listener) {
        this.messageListeners.add(listener);
    }

    /**
     * function removing a listener from the list of message arrival listener
     * @param listener the listener to remove
     */
    public void removeMessageListener(MessageListener listener) {
        this.messageListeners.remove(listener);
    }

    /**
     * Imbricated class handling messages
     */
    class MessageHandler implements MqttCallbackExtended {

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            if (topic.endsWith("Anki/Hosts/predictionGroup/s/emergencyStatus")) {
                Main.isInEmergency = message.toString().equals("true");
            } else if (topic.endsWith("/S/onTrack")) {

            }
            System.out.println("Message " + message + " has arrived on topic " + topic);

        }

        @Override
        public void connectComplete(boolean bln, String string) {
        }

        @Override
        public void connectionLost(Throwable thrwbl) {
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken imdt) {
        }
    }
}
