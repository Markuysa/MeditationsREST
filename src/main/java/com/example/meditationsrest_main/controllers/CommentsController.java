package com.example.meditationsrest_main.controllers;

import com.example.meditationsrest_main.models.Comment;
import com.example.meditationsrest_main.pojo.CommentDto;
import com.example.meditationsrest_main.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meditations/{meditationId}/comments")
@CrossOrigin(origins = "*")
public class CommentsController {
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @Autowired
    private CommentsService commentsService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN','MODERATOR')")
    public List<Comment> getAllCommentsForMeditation(@PathVariable Long meditationId) {
        return commentsService.getComments(meditationId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN','MODERATOR')")
    public Comment createComment(@PathVariable Long meditationId, @RequestBody CommentDto commentDto) {
        return commentsService.createComment(commentDto,meditationId);
    }
}