package com.oberasoftware.home.api.client;

import com.oberasoftware.home.api.model.ValueTransportMessage;

/**
 * @author Renze de Vries
 */
public interface StateServiceListener {
    void receive(ValueTransportMessage state);
}
