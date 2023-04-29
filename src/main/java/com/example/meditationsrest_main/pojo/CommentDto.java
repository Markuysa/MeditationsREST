package com.example.meditationsrest_main.pojo;


import com.example.meditationsrest_main.models.Comment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentDto {
    private Long userId;
    private Long meditationId;
    private String body;
    private Timestamp createdAt;


    public CommentDto(Long userId, Long meditationId, String body, Timestamp createdAt) {
        this.userId = userId;
        this.meditationId = meditationId;
        this.body = body;
        this.createdAt = createdAt;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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


    public Long getUserId() {
        return userId;
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


    public CommentDto(Comment comment) {
        this.userId = comment.getUserID();
        this.meditationId = comment.getMeditationId();
        this.body = comment.getBody();
        this.createdAt = comment.getCreatedAt();
    }
}
