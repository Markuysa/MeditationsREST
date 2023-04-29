package com.example.meditationsrest_main.repository;

import com.example.meditationsrest_main.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.meditationId = :meditationId AND c.reply IS NULL ORDER BY c.createdAt")
    List<Comment> findAllRootCommentsByMeditationId(@Param("meditationId") Long meditationId);

    @Query("SELECT c FROM Comment c WHERE c.meditationId = :meditationId AND c.reply = :replyId ORDER BY c.createdAt")
    List<Comment> findAllChildCommentsByMeditationIdAndReplyId(@Param("meditationId") Long meditationId, @Param("replyId") Long replyId);

    default List<Comment> findAllCommentsByMeditationId(Long meditationId) {
        List<Comment> comments = new ArrayList<>();
        List<Comment> rootComments = findAllRootCommentsByMeditationId(meditationId);
        for (Comment comment : rootComments) {
            comments.add(comment);
            comments.addAll(findAllChildComments(comment));
        }
        return comments;
    }

    private List<Comment> findAllChildComments(Comment comment) {
        List<Comment> comments = new ArrayList<>();
        List<Comment> childComments = findAllChildCommentsByMeditationIdAndReplyId(comment.getMeditationId(), comment.getId());
        for (Comment childComment : childComments) {
            comments.add(childComment);
            comments.addAll(findAllChildComments(childComment));
        }
        return comments;
    }
}

