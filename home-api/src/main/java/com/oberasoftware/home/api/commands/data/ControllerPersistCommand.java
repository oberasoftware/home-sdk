package com.oberasoftware.home.api.commands.data;

import com.oberasoftware.home.api.commands.Command;
import com.oberasoftware.home.api.model.Controller;

/**
 * @author renarj
 */
public class ControllerPersistCommand implements Command {
    private String controllerId;

    private Controller controller;

    public ControllerPersistCommand(String controllerId, Controller controller) {
        this.controllerId = controllerId;
        this.controller = controller;
    }

    public ControllerPersistCommand() {
    }

    public String getControllerId() {
        return controllerId;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
