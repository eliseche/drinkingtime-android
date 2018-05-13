package com.eliseche.drinkingtime.api.model;

import java.io.Serializable;

/**
 * An object used to describe where a video can be found.
 */
public class DrinkIngredient implements Serializable {
    private String id;
    private String type;
    private String text;
    private String textPlain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextPlain() {
        return textPlain;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
    }
}