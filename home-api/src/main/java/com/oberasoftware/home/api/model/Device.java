package com.oberasoftware.home.api.model;

import java.util.Map;

/**
 * @author renarj
 */
public interface Device extends HomeEntity {
    String getControllerId();

    Map<String, String> getProperties();
}
