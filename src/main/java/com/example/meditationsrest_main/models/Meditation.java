package com.example.meditationsrest_main.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="meditations")
public class Meditation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    @JsonIgnore
    String image;
    @Column(name = "videoURL")
    String video;
    @Column(name = "description")
    String description;

    @Column(name = "rating")
    Float rating;

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

    public Meditation(){};
    public Meditation(String image, String video, String description, Float rating) {
        this.image = image;
        this.video = video;
        this.description = description;
        this.rating = rating;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}