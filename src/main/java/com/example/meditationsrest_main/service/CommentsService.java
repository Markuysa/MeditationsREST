package com.example.meditationsrest_main.service;


import com.example.meditationsrest_main.models.Comment;
import com.example.meditationsrest_main.pojo.CommentDto;
import com.example.meditationsrest_main.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private CommentRepository commentsRepos;

    public CommentsService(CommentRepository commentsRepos) {
        this.commentsRepos = commentsRepos;
    }

    public List<Comment> getComments(Long meditationID){
        return commentsRepos.findAllCommentsByMeditationId(meditationID);
    }

    public Comment createComment(CommentDto commentDto, Long meditationId){
        Comment comment = new Comment();
        comment.setUserID(commentDto.getUserId());
        comment.setCreatedAt(commentDto.getCreatedAt());
        comment.setMeditationId(meditationId);
        comment.setBody(commentDto.getBody());
        return commentsRepos.save(comment);
    }

}
