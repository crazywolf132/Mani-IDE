package com.sol.ui;

import com.sol.Sol;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SolUI {

    private final Sol sol;
    private SolLayout layout;

    public SolUI(Sol sol) {
        this.sol = sol;
        this.layout = new SolLayout("ui");
    }

    public void initialize() {
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        Stage stage = sol.getStage();
    }
}
