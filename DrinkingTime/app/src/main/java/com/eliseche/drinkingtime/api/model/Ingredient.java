package com.eliseche.drinkingtime.api.model;

/**
 * Ingredients.
 */
public class Ingredient {
    private String id;
    private String name;
    private String languageBranch;
    private String description;
    private boolean isCarbonated;
    private boolean isAlcoholic;
    private boolean isBaseSpirit;
    private boolean isJuice;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguageBranch() {
        return languageBranch;
    }

    public void setLanguageBranch(String languageBranch) {
        this.languageBranch = languageBranch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCarbonated() {
        return isCarbonated;
    }

    public void setCarbonated(boolean carbonated) {
        isCarbonated = carbonated;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public boolean isBaseSpirit() {
        return isBaseSpirit;
    }

    public void setBaseSpirit(boolean baseSpirit) {
        isBaseSpirit = baseSpirit;
    }

    public boolean isJuice() {
        return isJuice;
    }

    public void setJuice(boolean juice) {
        isJuice = juice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}