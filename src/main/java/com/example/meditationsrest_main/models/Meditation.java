package com.example.meditationsrest_main.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="meditations")
public class Meditation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    String image;
    @Column(name = "videoURL")
    String video;
    @Column(name = "description")
    String description;

    @Column(name = "rating")
    Float rating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "meditation_category",
            joinColumns = {@JoinColumn(name = "meditation_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<Category> categories = new HashSet<>();

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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}