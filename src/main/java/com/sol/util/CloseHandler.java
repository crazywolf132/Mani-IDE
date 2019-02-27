package com.sol.util;

import com.sol.Sol;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class CloseHandler implements EventHandler<WindowEvent> {

    private final Sol sol;

    public CloseHandler(Sol sol) { this.sol = sol; }

    @Override
    public void handle(WindowEvent event) { sol.exit(); }
}
