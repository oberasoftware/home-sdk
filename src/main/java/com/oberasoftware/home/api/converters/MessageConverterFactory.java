package com.oberasoftware.home.api.converters;

/**
 * @author Renze de Vries
 */
public interface MessageConverterFactory extends MessageConverter {


    <S, T> MessageConverter createConverter(S source, Class<?> targetType);
}
