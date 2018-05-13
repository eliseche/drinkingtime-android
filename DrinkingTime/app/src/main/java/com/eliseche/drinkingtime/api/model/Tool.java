package com.eliseche.drinkingtime.api.model;

import java.util.List;

/**
 * Tools.
 */
public class Tool {
    private String id;
    private String name;
    private String languageBranch;
    private String description;
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

    public List<VideoReference> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoReference> videos) {
        this.videos = videos;
    }
}