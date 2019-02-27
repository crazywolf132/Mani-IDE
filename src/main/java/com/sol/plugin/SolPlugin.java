package com.sol.plugin;

import com.sol.Sol;

public abstract class SolPlugin {

    protected  PluginProperties pluginProperties;

    public SolPlugin() { this.pluginProperties.getClass().getAnnotation(PluginProperties.class); }

    protected final void initialize() {
        if (pluginProperties == null) {
            throw new RuntimeException("SolPlugin without PluginProperties annotation.");
        }
    }

    public void onLoad() {

    }

    public String getVersion() { return pluginProperties.version(); }

    public String getName() { return pluginProperties.name(); }

    public PluginProperties getPluginProperties() { return pluginProperties; }

    public abstract void onEnable(Sol sol);

    public abstract  void onDisable();
}
