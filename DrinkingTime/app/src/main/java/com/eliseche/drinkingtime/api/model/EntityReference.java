package com.eliseche.drinkingtime.api.model;

import java.io.Serializable;

/**
 * A entity reference is used to refer from one resource to another resource in the ADDb.
 */
public class EntityReference implements Serializable {
    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}