package com.sol.plugin.editor;

import com.sol.Sol;
import com.sol.util.IOUtils;
import com.sol.util.ResourcesBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class EditorTab extends Tab implements Initializable {

    private static final String template;

    static {
        // Starting template
        ResourcesBuilder resourcesBuilder = new ResourcesBuilder();
        resourcesBuilder.importCss("/libs/codemirror/style.min.css");
        resourcesBuilder.importScript("/libs/codemirror/script.min.js");
        resourcesBuilder.importScript("/libs/codemirror/mani.min.js");
        template = IOUtils.convertStreamToString(Sol.class.getResourceAsStream("/plugins/editor/editor.html"))
                .replace("{imports}", resourcesBuilder.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
