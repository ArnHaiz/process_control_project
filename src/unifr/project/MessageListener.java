package unifr.project;

import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Interface allowing to listen to messages
 *
 * @author Reto Koenig
 */
public interface MessageListener {
    /**
     * function adding messages and the topic they were published to to a queue
     * @param topic the topic the message was published to
     * @param message the message that was published
     */
    public void addMQTTMessage(String topic, MqttMessage message);
    
}