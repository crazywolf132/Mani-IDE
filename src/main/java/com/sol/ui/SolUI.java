package com.sol.ui;

import com.sol.Sol;
import com.sol.util.CloseHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        stage.setWidth(bounds.getWidth() - 2);
        stage.setHeight(bounds.getHeight() * 0.9);
        stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((bounds.getHeight() - stage.getHeight()) / 2);

        Parent root = layout.getBorderPane();
        //TODO: Create style sheets...
        //root.getStylesheets().add();

        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
        stage.setScene(scene);

        CloseHandler handler = new CloseHandler(sol);
    }

    public SolLayout getLayout() { return layout; }
    
    public Sol getSol() { return sol; }
}
