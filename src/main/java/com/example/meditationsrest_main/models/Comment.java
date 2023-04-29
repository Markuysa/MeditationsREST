package com.example.meditationsrest_main.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userID;

    @Column(name = "meditation_id")
    private Long meditationId;

    @Column(name = "body")
    private String body;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "reply")
    private Long reply;

    public Comment() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setMeditationId(Long meditationId) {
        this.meditationId = meditationId;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setReply(Long reply) {
        this.reply = reply;
    }

    public Long getId() {
        return id;
    }

    public Long getUserID() {
        return userID;
    }

    public Long getMeditationId() {
        return meditationId;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Long getReply() {
        return reply;
    }

    public Comment(Long id, Long userID, Long meditationId, String body, Timestamp createdAt, Long reply) {
        this.id = id;
        this.userID = userID;
        this.meditationId = meditationId;
        this.body = body;
        this.createdAt = createdAt;
        this.reply = reply;
    }
}
