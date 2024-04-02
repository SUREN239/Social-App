package suren.socialapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suren.socialapp.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
