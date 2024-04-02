package suren.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suren.socialapp.model.Comment;
import suren.socialapp.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Long postId, Comment comment) {
        // Logic to create a comment for a post
        comment.setPostId(postId);
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long postId, Long commentId) {
        // Logic to retrieve a comment by ID for a specific post
        return commentRepository.findByPostIdAndId(postId, commentId).orElse(null);
    }

    public Comment updateComment(Long postId, Long commentId, Comment updatedComment) {
        // Logic to update a comment for a post
        updatedComment.setId(commentId);
        updatedComment.setPostId(postId);
        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long postId, Long commentId) {
        // Logic to delete a comment for a post
        commentRepository.deleteByPostIdAndId(postId, commentId);
    }
}

