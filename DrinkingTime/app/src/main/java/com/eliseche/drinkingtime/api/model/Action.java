package com.eliseche.drinkingtime.api.model;

import java.util.List;

/**
 * An Action represents something you do in the process of making a Drink, for an example Blending.
 */
public class Action {
    private String id;
    private String name;
    private String languageBranch;
    private String description;
    private EntityReference tool;
    private List<VideoReference> videos;

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

    public EntityReference getTool() {
        return tool;
    }

    public void setTool(EntityReference tool) {
        this.tool = tool;
    }

    public List<VideoReference> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoReference> videos) {
        this.videos = videos;
    }
}