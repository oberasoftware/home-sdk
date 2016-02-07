package com.oberasoftware.home.api.extensions;

import com.oberasoftware.home.api.commands.handlers.CommandHandler;

import java.util.Map;

/**
 * @author renarj
 */
public interface AutomationExtension {
    String getId();

    String getName();

    Map<String, String> getProperties();

    CommandHandler getCommandHandler();

    boolean isReady();

    void activate();
}
