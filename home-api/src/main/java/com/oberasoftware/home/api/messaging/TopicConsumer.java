package com.oberasoftware.home.api.messaging;

/**
 * @author Renze de Vries
 */
public interface TopicConsumer<T> {
    void receive(T message);
}
