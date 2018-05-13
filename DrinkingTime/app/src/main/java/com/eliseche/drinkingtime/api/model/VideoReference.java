package com.eliseche.drinkingtime.api.model;

import java.io.Serializable;

/**
 * An object used to describe where a video can be found.
 */
public class VideoReference implements Serializable {
    private String video;
    private String type;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}