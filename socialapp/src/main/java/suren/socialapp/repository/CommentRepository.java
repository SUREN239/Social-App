package suren.socialapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suren.socialapp.model.Comment;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByPostIdAndId(Long postId, Long commentId);
    void deleteByPostIdAndId(Long postId, Long commentId);
}
