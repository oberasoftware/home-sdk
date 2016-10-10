package com.oberasoftware.home.api.impl.state;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

    private String controllerId;
    private String itemId;

    @JsonDeserialize(as = StateItemImpl.class)
    private Map<String, StateItem> states = new HashMap<>();

    public StateImpl(String controllerId, String itemId, List<StateItem> stateItems) {
        this.controllerId = controllerId;
        this.itemId = itemId;
        stateItems.forEach(s -> states.put(s.getLabel(), s));
    }

    public StateImpl() {
    }

    @Override
    public String getControllerId() {
        return this.controllerId;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public List<StateItem> getStateItems() {
        return Lists.newArrayList(states.values());
    }

    @JsonDeserialize(contentAs = StateItemImpl.class)
    public void setStates(Map<String, StateItem> states) {
        this.states = states;
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
