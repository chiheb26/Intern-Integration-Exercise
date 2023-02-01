package com.minotore.bookapp.utils;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoryType {
    HISTORCAL,CRIME,FASHION,FICTION,COOKING,DEFAULT;

    @JsonCreator
    public static CategoryType fromValue(String type) {
        try {
            return CategoryType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return DEFAULT; // if nor enum instance available for type, then use the default one.
        }
    }
}
