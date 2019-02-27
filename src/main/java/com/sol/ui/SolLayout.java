package com.sol.ui;

import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Collection;

public class SolLayout {

    private final String name;
    private final Collection<SolLayout> layouts;
    private final BorderPane borderPane;

    public SolLayout(String name) { this(name, new BorderPane()); }

    public SolLayout(String name, BorderPane borderPane) {
        this.name = name;
        this.borderPane = borderPane;
        this.layouts = new ArrayList<>();
    }

    public SolLayout findLayout(String name) {
        if (getName().equals(name)) {
            return this;
        }

        for (SolLayout layout: layouts) {
            String layoutName = layout.getName();

            if (layoutName.equals(name)) {
                return layout;
            }
        }

        return null;
    }

    public void addLayout(SolLayout layout) { layouts.add(layout); }
    public BorderPane getBorderPane() { return borderPane; }
    public Collection<SolLayout> getLayouts() { return layouts; }
    public String getName() { return name; }
}
