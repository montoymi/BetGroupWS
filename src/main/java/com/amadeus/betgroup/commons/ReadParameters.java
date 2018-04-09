package com.amadeus.betgroup.commons;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ReadParameters {
    private static final String BUNDLE_NAME = "com.amadeus.commons.Parameters";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString( key );
        } catch ( MissingResourceException e ) {
            e.printStackTrace();
            return '!' + key + '!';
        }
    }
}
