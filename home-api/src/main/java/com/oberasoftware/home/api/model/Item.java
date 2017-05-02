package com.oberasoftware.home.api.model;

import java.util.Map;

/**
 * @author renarj
 */
public interface Item extends HomeEntity {
    Map<String, String> getProperties();
}
