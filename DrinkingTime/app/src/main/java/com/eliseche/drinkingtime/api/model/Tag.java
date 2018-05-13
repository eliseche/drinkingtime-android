package com.eliseche.drinkingtime.api.model;

import java.io.Serializable;

/**
 * Tags are the way to construct groups of Drinks for any drinks that you find related to each other and that you have
 * a use for in your app. Tags are applied to Drinks and each app manage their own tags.
 * Example of use: All drinks on the articles of absolutdrinks.com are chosen and tagged together by the Absolut team.
 */
public class Tag implements Serializable {
    private String name;
    private String owner;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}