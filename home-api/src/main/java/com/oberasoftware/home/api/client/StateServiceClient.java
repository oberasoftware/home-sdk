package com.oberasoftware.home.api.client;

/**
 * @author Renze de Vries
 */
public interface StateServiceClient {
    void connect();

    void disconnect();

    void listen(StateServiceListener listener);
}
