package com.example.meditationsrest_main.pojo;

public class MeditationRequest {
    public String description;
    public String image;
    public Float rating;
    public String videourl;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Float getRating() {
        return rating;
    }

    public String getVideourl() {
        return videourl;
    }

    public MeditationRequest(String description, String image, Float rating, String videourl) {
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.videourl = videourl;
    }
}
