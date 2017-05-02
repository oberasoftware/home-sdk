package com.oberasoftware.home.api.client;

import com.oberasoftware.home.api.model.impl.ValueTransportMessage;

/**
 * @author Renze de Vries
 */
public interface StateServiceListener {
    void receive(ValueTransportMessage state);
}
