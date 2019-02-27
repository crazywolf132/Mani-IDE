package com.sol;

import com.sol.plugin.PluginFinder;
import com.sol.plugin.PluginManager;
import com.sol.ui.SolUI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Sol extends Application{

    public static Sol instance;

    private final PluginManager pluginManager;
    private Stage stage;
    private SolUI ui;

    public Sol() {
        instance = this;

        this.pluginManager = new PluginManager(this);

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.ui = new SolUI(this);

        PluginFinder pluginFinder = new PluginFinder(pluginManager);
        pluginFinder.find();

        ui.initialize();
        pluginManager.loadPlugins();
        pluginManager.enablePlugins();

        stage.show();
    }

    public void exit() {
        pluginManager.disablePlugins();

        Platform.exit();
        System.exit(-1);
    }

    public SolUI getUI() { return this.ui; }

    public Stage getStage() { return this.stage; }

    public static Sol getInstance() { return instance; }
}
