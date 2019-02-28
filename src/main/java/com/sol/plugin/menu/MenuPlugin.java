package com.sol.plugin.menu;

import com.sol.Sol;
import com.sol.SolConts;
import com.sol.plugin.PluginProperties;
import com.sol.plugin.SolPlugin;
import com.sol.ui.SolLayout;
import com.sol.ui.SolUI;
import javafx.scene.layout.BorderPane;

@PluginProperties(name = "Console", version = SolConts.VERSION)
public class MenuPlugin extends SolPlugin {

    private Menu menu;

    @Override
    public void onEnable(Sol sol) {
        this.menu = new Menu();

        SolUI ui = sol.getUI();
        SolLayout layout = ui.getLayout();
        BorderPane borderPane = layout.getBorderPane();

        SolLayout menuLayout = new SolLayout("menu", menu);
        layout.addLayout(menuLayout);
        borderPane.setTop(menu);
    }

    @Override
    public void onDisable() {

    }

    public Menu getMenu() { return menu; }
}
