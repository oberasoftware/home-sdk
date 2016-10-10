package com.oberasoftware.home.client.command;

import com.oberasoftware.home.api.client.ClientResponse;
import com.oberasoftware.home.api.client.CommandServiceClient;
import com.oberasoftware.home.api.commands.BasicCommand;
import com.oberasoftware.home.api.model.BasicCommandImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author Renze de Vries
 */
@Component
public class BasicCommandServiceClient implements CommandServiceClient {

    @Value("${command_svc_url}")
    private String commandServiceBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Future<ClientResponse> sendAsyncCommand(BasicCommand basicCommand) {
        return null;
    }

    @Override
    public ClientResponse sendCommand(BasicCommand basicCommand) {
        ResponseEntity<BasicCommandImpl> response = restTemplate.postForEntity(getCommandUrl(), basicCommand, BasicCommandImpl.class);

        return () -> response.getStatusCode() == HttpStatus.OK ? ClientResponse.RESPONSE_STATUS.OK : ClientResponse.RESPONSE_STATUS.FAILED;
    }

    private String getCommandUrl() {
        String url = commandServiceBaseUrl;
        if(!commandServiceBaseUrl.endsWith("/")) {
            url += "/";
        }

        return url + "command/";
    }
}
