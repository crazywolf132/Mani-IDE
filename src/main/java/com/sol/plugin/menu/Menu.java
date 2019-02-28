package com.sol.plugin.menu;

import com.sol.util.FXMLLoaderUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu extends BorderPane implements Initializable {

    @FXML public MenuItem menuFileSettings;
    @FXML public MenuItem menuFileSaveAll;
    @FXML public MenuItem menuEditRedo;
    @FXML public MenuItem menuEditCut;
    @FXML public MenuItem menuEditCopy;
    @FXML public MenuItem menuEditPaste;
    @FXML public MenuItem menuEditFind;
    @FXML public MenuItem menuEditSelectAll;
    @FXML public MenuItem menuEditDelete;
    @FXML private MenuItem menuFileNew;
    @FXML private MenuItem menuFileOpenFile;
    @FXML private MenuItem menuFileOpenFolder;
    @FXML private MenuItem menuFileExit;
    @FXML private MenuItem menuEditUndo;
    @FXML private MenuItem menuRunRun;
    @FXML private MenuItem menuGitClone;
    @FXML private MenuItem menuHelpAbout;


    public Menu() {
        FXMLLoaderUtils.loadElementFromResources(this, "/plugins/menu/menu.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MenuUtils.extend(menuFileOpenFolder);
        MenuUtils.extend(menuEditUndo);
        MenuUtils.extend(menuRunRun);
        MenuUtils.extend(menuGitClone);
        MenuUtils.extend(menuHelpAbout);
    }
}
