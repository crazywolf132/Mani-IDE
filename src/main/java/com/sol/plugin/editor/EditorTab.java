package com.sol.plugin.editor;

import com.sol.Sol;
import com.sol.util.FXMLLoaderUtils;
import com.sol.util.FileUtils;
import com.sol.util.IOUtils;
import com.sol.util.ResourcesBuilder;
import com.sol.util.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    @FXML private WebView webView;

    private WebEngine webEngine;
    private String title;
    private boolean changed;
    private boolean succeeded;

    public EditorTab() {
        super();
        FXMLLoaderUtils.loadElementFromResources(this, "/plugins/editor/tab.fxml");
    }

    public static String getTemplate() { return template; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Style
        webEngine = webView.getEngine();
        GridPane.setHgrow(webView, Priority.ALWAYS);
        GridPane.setVgrow(webView, Priority.ALWAYS);
    }

    public void run(TabPane pane, File file) {
        if (file == null) {
            return;
        }

        // Tab Settings
        this.title = file.getName();
        setText(title);

        // Engine settings
        webView.setVisible(true);
        webEngine.setJavaScriptEnabled(true);

        // Load source
        String source = FileUtils.getContentOfFile(file);
        source = StringUtils.replace(source, "    ", "\t");

        // Load content
        String content = template.replace("{code}", source);
        webEngine.loadContent(content);
        webView.setUserData(file);

        // Tabs
        pane.getTabs().add(this);
        pane.getSelectionModel().select(this);

        // Accelerators
        webView.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY), () -> {
           File f = (File) webView.getUserData();
           String src = (String) webEngine.executeScript("editor.getValue()");

           FileUtils.overrideFile(f, src);
           setText(title);
           changed = false;
        });

        // State listener
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldValue, newValue) -> {
            switch (newValue) {
                case SUCCEEDED: {
                    succeeded = true;
                }
            }
        });

        // EVENTS
        webView.setOnKeyPressed(key -> {
            if (!changed) {
                KeyCode keyCode = key.getCode();
                if (keyCode.isLetterKey() || keyCode.isDigitKey() || keyCode.isWhitespaceKey() || keyCode == KeyCode.BACK_SPACE) {
                    setText(title + " *");
                    changed = true;
                }
            }
        });
    }

    public boolean isChanged() { return changed; }
    public boolean isSucceeded() { return succeeded; }

    public WebEngine getWebEngine() { return webEngine; }
    public WebView getWebView() { return webView; }

    public void setWebView(WebView webView) { this.webView = webView; }

    public Tab getTab() { return this; }
    
    public String getTitle() { return title; }
}
