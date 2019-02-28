package com.sol.util;

import com.sol.Sol;

public class ResourcesBuilder {

    private final StringBuilder stringBuilder;

    public ResourcesBuilder() { this.stringBuilder = new StringBuilder(); }

    public void importCss(String file) {
        stringBuilder.append("<link rel=\"stylesheet\" href=\"");
        stringBuilder.append(Sol.class.getResource(file).toExternalForm());
        stringBuilder.append("\">");
    }

    public void importScript(String file) {
        stringBuilder.append("<script src=\"");
        stringBuilder.append(Sol.class.getResource(file).toExternalForm());
        stringBuilder.append("\"></script>");
    }

    public StringBuilder getStringBuilder() { return stringBuilder; }

    @Override
    public String toString() { return stringBuilder.toString(); }
}
