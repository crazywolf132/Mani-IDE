package com.sol.util;

import com.sol.Sol;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class FXMLLoaderUtils {

    public static void loadElementFromResources(Object element, String location) {
        FXMLLoader fxmlLoader = new FXMLLoader(Sol.class.getResource(location));
        fxmlLoader.setRoot(element);
        fxmlLoader.setController(element);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
