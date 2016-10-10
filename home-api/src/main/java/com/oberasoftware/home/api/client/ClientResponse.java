package com.oberasoftware.home.api.client;

/**
 * @author Renze de Vries
 */
public interface ClientResponse {

    enum RESPONSE_STATUS {
        OK,
        FAILED
    }


    RESPONSE_STATUS getStatus();
}
