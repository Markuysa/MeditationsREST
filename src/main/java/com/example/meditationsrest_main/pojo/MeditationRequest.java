package com.example.meditationsrest_main.pojo;

import com.example.meditationsrest_main.models.Category;

import java.util.Set;

public class MeditationRequest {
    private String image;
    private String video;
    private String description;
    private Float rating;
    private Set<String> categories;

    public void setImage(String image) {
        this.image = image;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public String getVideo() {
        return video;
    }

    public String getDescription() {
        return description;
    }

    public Float getRating() {
        return rating;
    }

    public MeditationRequest(String image, String video, String description, Float rating, Set<String> categories) {
        this.image = image;
        this.video = video;
        this.description = description;
        this.rating = rating;
        this.categories = categories;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String > categories) {
        this.categories = categories;
    }
}
