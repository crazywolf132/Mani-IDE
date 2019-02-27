package com.sol.ui;

import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Collection;

public class ManiLayout {

    private final String name;
    private final Collection<ManiLayout> layouts;
    private final BorderPane borderPane;

    public ManiLayout(String name) { this(name, new BorderPane()); }

    public ManiLayout(String name, BorderPane borderPane) {
        this.name = name;
        this.borderPane = borderPane;
        this.layouts = new ArrayList<>();
    }

    public ManiLayout findLayout(String name) {
        if (getName().equals(name)) {
            return this;
        }

        for (ManiLayout layout: layouts) {
            String layoutName = layout.getName();

            if (layoutName.equals(name)) {
                return layout;
            }
        }

        return null;
    }

    public void addLayout(ManiLayout layout) { layouts.add(layout); }
    public BorderPane getBorderPane() { return borderPane; }
    public Collection<ManiLayout> getLayouts() { return layouts; }
    public String getName() { return name; }
}
