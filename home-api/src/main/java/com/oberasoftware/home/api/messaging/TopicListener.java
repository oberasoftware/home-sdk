package com.oberasoftware.home.api.messaging;

/**
 * @author Renze de Vries
 */
public interface TopicListener<T> {
    void connect();

    void close();

    void register(TopicConsumer<T> topicConsumer);
}
