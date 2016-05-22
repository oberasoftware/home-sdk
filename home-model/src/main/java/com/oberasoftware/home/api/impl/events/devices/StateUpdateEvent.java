package com.oberasoftware.home.api.impl.events.devices;

import com.oberasoftware.home.api.events.ItemEvent;
import com.oberasoftware.home.api.model.State;

/**
 * @author renarj
 */
public class StateUpdateEvent implements ItemEvent {
    private final State state;
    private final String itemId;
    private final String controllerId;

    public StateUpdateEvent(State state) {
        this.state = state;
        this.itemId = state.getItemId();
        this.controllerId = state.getControllerId();
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    public String getControllerId() {
        return controllerId;
    }

    public State getState() {
        return state;
    }
}
