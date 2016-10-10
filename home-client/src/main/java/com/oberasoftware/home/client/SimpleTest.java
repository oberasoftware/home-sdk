package com.oberasoftware.home.client;

import com.oberasoftware.home.api.commands.BasicCommand;
import com.oberasoftware.home.api.model.BasicCommandBuilder;
import com.oberasoftware.home.client.command.BasicCommandServiceClient;
import com.oberasoftware.home.client.command.CommandClientConfiguration;
import com.oberasoftware.home.client.state.StateClientConfiguration;
import com.oberasoftware.home.client.state.StateServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author Renze de Vries
 */
@SpringBootApplication
@ComponentScan
@Import({CommandClientConfiguration.class, StateClientConfiguration.class})
public class SimpleTest {
    public static void main(String[] args) {
        ApplicationContext c = SpringApplication.run(SimpleTest.class);
        BasicCommandServiceClient client = c.getBean(BasicCommandServiceClient.class);

        StateServiceClient serviceClient = c.getBean(StateServiceClient.class);
        serviceClient.connect();

        BasicCommand command = BasicCommandBuilder.create("max").item("test").label("bark").property("testerdetest", "blaat").build();
        client.sendCommand(command);
    }
}
