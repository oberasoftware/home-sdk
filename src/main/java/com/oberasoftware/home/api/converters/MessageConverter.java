package com.oberasoftware.home.api.converters;

/**
 * @author renarj
 */
public interface MessageConverter<S, T> {
    T map(S source);
}
