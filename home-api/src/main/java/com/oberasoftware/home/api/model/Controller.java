package com.oberasoftware.home.api.model;

import java.util.List;

/**
 * @author Renze de Vries
 */
public interface Controller extends HomeEntity {
    String getControllerId();

    List<Device> getDevices();
}
