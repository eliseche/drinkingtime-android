package com.eliseche.drinkingtime.api.model;

import java.io.Serializable;
import java.util.List;

/**
 * The Drink is ADDb:s settings resource. It contains all the information needed to create the drink.
 */
public class Drink implements Serializable {
    private String id;
    private String name;
    private String description;
    private String descriptionPlain;
    private String story;
    private String color;
    private String languageBranch;
    private int rating;
    private SkillType skill;
    private List<VideoReference> videos;
    private boolean isAlcoholic;
    private boolean isCarbonated;
    private boolean isHot;
    private EntityReference servedIn;
    private List<DrinkIngredient> ingredients;
    private List<EntityReference> tastes;
    private List<EntityReference> occasions;
    private List<EntityReference> tools;
    private List<EntityReference> drinkTypes;
    private List<EntityReference> actions;
    private List<String> brands;
    private List<Tag> tags;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionPlain() {
        return descriptionPlain;
    }

    public void setDescriptionPlain(String descriptionPlain) {
        this.descriptionPlain = descriptionPlain;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLanguageBranch() {
        return languageBranch;
    }

    public void setLanguageBranch(String languageBranch) {
        this.languageBranch = languageBranch;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public SkillType getSkill() {
        return skill;
    }

    public void setSkill(SkillType skill) {
        this.skill = skill;
    }

    public List<VideoReference> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoReference> videos) {
        this.videos = videos;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public boolean isCarbonated() {
        return isCarbonated;
    }

    public void setCarbonated(boolean carbonated) {
        isCarbonated = carbonated;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public EntityReference getServedIn() {
        return servedIn;
    }

    public void setServedIn(EntityReference servedIn) {
        this.servedIn = servedIn;
    }

    public List<DrinkIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DrinkIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<EntityReference> getTastes() {
        return tastes;
    }

    public void setTastes(List<EntityReference> tastes) {
        this.tastes = tastes;
    }

    public List<EntityReference> getOccasions() {
        return occasions;
    }

    public void setOccasions(List<EntityReference> occasions) {
        this.occasions = occasions;
    }

    public List<EntityReference> getTools() {
        return tools;
    }

    public void setTools(List<EntityReference> tools) {
        this.tools = tools;
    }

    public List<EntityReference> getDrinkTypes() {
        return drinkTypes;
    }

    public void setDrinkTypes(List<EntityReference> drinkTypes) {
        this.drinkTypes = drinkTypes;
    }

    public List<EntityReference> getActions() {
        return actions;
    }

    public void setActions(List<EntityReference> actions) {
        this.actions = actions;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}