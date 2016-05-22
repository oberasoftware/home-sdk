package com.oberasoftware.home.api.impl.state;

import com.google.common.collect.Lists;
import com.oberasoftware.home.api.model.State;
import com.oberasoftware.home.api.model.StateItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author renarj
 */
public class StateImpl implements State {

    private final String controllerId;
    private final String itemId;
    private final Map<String, StateItem> states = new HashMap<>();

    public StateImpl(String controllerId, String itemId, List<StateItem> stateItems) {
        this.controllerId = controllerId;
        this.itemId = itemId;
        stateItems.forEach(s -> states.put(s.getLabel(), s));
    }

    @Override
    public String getControllerId() {
        return this.controllerId;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public List<StateItem> getStateItems() {
        return Lists.newArrayList(states.values());
    }

    @Override
    public StateItem getStateItem(String label) {
        return states.get(label.toLowerCase());
    }

    @Override
    public String toString() {
        return "StateImpl{" +
                "itemId='" + itemId + '\'' +
                ", stateItems=" + states +
                '}';
    }
}
