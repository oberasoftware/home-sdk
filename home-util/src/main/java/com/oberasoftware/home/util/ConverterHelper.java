package com.oberasoftware.home.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oberasoftware.home.api.exceptions.RuntimeHomeAutomationException;
import com.oberasoftware.home.api.model.ValueTransportMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Renze de Vries
 */
public class ConverterHelper {
    private static final Logger LOG = LoggerFactory.getLogger(ConverterHelper.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.enableDefaultTyping();
    }

    public static <T> T mapFromJson(String json, Class<T> targetType) {
        try {
            return OBJECT_MAPPER.readValue(json, targetType);
        } catch (IOException e) {
            LOG.error("Unable to map json", e);
            throw new RuntimeHomeAutomationException("Could not map JSON", e);
        }
    }

    public static String mapToJson(Object mappableObject) {
        try {
            return OBJECT_MAPPER.writeValueAsString(mappableObject);
        } catch (JsonProcessingException e) {
            LOG.error("Unable to map json", e);
            throw new RuntimeHomeAutomationException("Could not map JSON", e);
        }
    }

    public static void main(String[] args) {

        mapFromJson("{\"value\":{\"value\":520,\"type\":\"NUMBER\"},\"controllerId\":\"max\",\"channelId\":\"Hand\",\"label\":\"5\"}", ValueTransportMessage.class);
    }
}
