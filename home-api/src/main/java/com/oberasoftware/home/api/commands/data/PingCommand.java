package com.oberasoftware.home.api.commands.data;

import com.oberasoftware.home.api.commands.Command;

/**
 * @author renarj
 */
public class PingCommand implements Command {
    private String controllerId;

    public PingCommand(String controllerId) {
        this.controllerId = controllerId;
    }

    public PingCommand() {
    }

    public String getControllerId() {
        return controllerId;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }
}
