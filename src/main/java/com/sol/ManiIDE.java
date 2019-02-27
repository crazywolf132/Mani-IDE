package com.sol;

import javafx.application.Application;
import javafx.stage.Stage;

public class ManiIDE extends Application{

    public static ManiIDE instance;

    private Stage stage;
    private ManiUI ui;

    public ManiIDE() {
        instance = this;

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.ui = new ManiUI(this);

        ui.initialize();

        stage.show();
    }
}
