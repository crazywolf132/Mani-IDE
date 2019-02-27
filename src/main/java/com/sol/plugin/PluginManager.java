package com.sol.plugin;

import com.sol.Sol;

import java.util.ArrayList;
import java.util.Collection;

public class PluginManager {

    private final Sol sol;
    private final Collection<SolPlugin> plugins;

    public PluginManager(Sol sol) {
        this.sol = sol;
        this.plugins = new ArrayList<>();
    }

    public void loadPlugins() {
        for (SolPlugin plugin : plugins) {
            plugin.onLoad();
        }
    }

    public void enablePlugins() {
        for(SolPlugin plugin : plugins) {
            plugin.onEnable(sol);
        }
    }

    public void disablePlugins() {
        for (SolPlugin plugin : plugins) {
            plugin.onDisable();
        }
    }

    public void registerPlugin(SolPlugin solPlugin) { plugins.add(solPlugin); }

    public <T extends SolPlugin> T getPlugin(String name) {
        for (SolPlugin plugin : plugins) {
            String pluginName = plugin.getName();

            if (name.equals(pluginName)) {
                return (T) plugin;
            }
        }

        return null;
    }

    public Collection<SolPlugin> getPlugins() { return plugins; }
}
