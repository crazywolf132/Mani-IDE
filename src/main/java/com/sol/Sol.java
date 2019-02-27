package com.sol;

import com.sol.ui.SolUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Sol extends Application{

    public static Sol instance;

    private Stage stage;
    private SolUI ui;

    public Sol() {
        instance = this;

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.ui = new SolUI(this);

        ui.initialize();

        stage.show();
    }
}
