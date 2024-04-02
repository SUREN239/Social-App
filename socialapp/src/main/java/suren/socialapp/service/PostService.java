package suren.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suren.socialapp.model.Post;
import suren.socialapp.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        // Logic to create a post
        return postRepository.save(post);
    }

    public Post getPostById(Long postId) {
        // Logic to retrieve a post by ID
        return postRepository.findById(postId).orElse(null);
    }

    public Post updatePost(Long postId, Post updatedPost) {
        // Logic to update a post
        updatedPost.setId(postId);
        return postRepository.save(updatedPost);
    }

    public void deletePost(Long postId) {
        // Logic to delete a post
        postRepository.deleteById(postId);
    }
}

