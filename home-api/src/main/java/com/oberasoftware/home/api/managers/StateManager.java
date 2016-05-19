package com.oberasoftware.home.api.managers;

import com.oberasoftware.home.api.model.State;
import com.oberasoftware.home.api.types.Value;

import java.util.Map;

/**
 * @author renarj
 */
public interface StateManager {
    State updateItemState(String controllerId, String itemId, String label, Value value);

    State getItemState(String controllerId, String itemId);

    Map<String, State> getStates(String controllerId);
}
