package com.sol;

import com.sol.ui.SolUI;
import javafx.application.Application;
import javafx.application.Platform;
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

    public void exit() {
        Platform.exit();
        System.exit(-1);
    }

    public SolUI getUI() { return this.ui; }

    public Stage getStage() { return this.stage; }

    public static Sol getInstance() { return instance; }
}
