package com.eliseche.drinkingtime.api.model;

import java.util.List;

/**
 * A Glass represents a serving glass in which drinks are served.
 */
public class Glass {
    private String id;
    private String name;
    private String description;
    private String languageBranch;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguageBranch() {
        return languageBranch;
    }

    public void setLanguageBranch(String languageBranch) {
        this.languageBranch = languageBranch;
    }

    public List<VideoReference> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoReference> videos) {
        this.videos = videos;
    }
}