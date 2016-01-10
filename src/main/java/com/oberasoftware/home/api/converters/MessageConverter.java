package com.oberasoftware.home.api.converters;

/**
 * This is the a message converter interface
 *
 * @author Renze de Vries
 */
public interface MessageConverter {

    /**
     * This converts the specified source message into the target type using all converters that are available
     *
     * @param source     The source
     * @param targetType The target type class
     * @param <T>        The target type
     * @param <S>        The source type
     * @return The converted source into a target message type
     */
    <T, S> T convert(S source, Class<T> targetType);
}
