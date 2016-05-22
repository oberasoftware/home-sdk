package com.oberasoftware.home.api.model;

import java.util.List;

/**
 * @author renarj
 */
public interface State {

    String getControllerId();

    String getItemId();

    List<StateItem> getStateItems();

    StateItem getStateItem(String label);
}
