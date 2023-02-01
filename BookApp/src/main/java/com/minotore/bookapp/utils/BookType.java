package com.minotore.bookapp.utils;

import com.fasterxml.jackson.annotation.JsonCreator;



public enum BookType {
    MAGAZINE,NOVEL,DEFAULT;



    @JsonCreator
    public static BookType fromValue(String type) {
        try {
            return BookType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return DEFAULT; // if nor enum instance available for type, then use the default one.
        }
    }


}
