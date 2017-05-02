package com.oberasoftware.home.api.managers;

import com.oberasoftware.home.api.model.State;
import com.oberasoftware.home.api.model.Value;

import java.util.List;

/**
 * @author renarj
 */
public interface StateManager {
    State setState(String controllerId, String itemId, String label, Value value);

    State getState(String controllerId, String itemId);

    List<State> getStates(String controllerId);
}
