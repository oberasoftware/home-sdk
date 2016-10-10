package com.oberasoftware.home.api.client;

import com.oberasoftware.home.api.commands.BasicCommand;

import java.util.concurrent.Future;

/**
 * Basic client interface for callingthe co
 *
 * @author Renze de Vries
 */
public interface CommandServiceClient {
    Future<ClientResponse> sendAsyncCommand(BasicCommand basicCommand);

    ClientResponse sendCommand(BasicCommand basicCommand);
}
