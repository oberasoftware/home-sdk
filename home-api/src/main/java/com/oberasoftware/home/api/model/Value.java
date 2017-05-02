package com.oberasoftware.home.api.model;

/**
 * @author renarj
 */
public interface Value {
    VALUE_TYPE getType();

    <T> T getValue();

    String asString();
}
