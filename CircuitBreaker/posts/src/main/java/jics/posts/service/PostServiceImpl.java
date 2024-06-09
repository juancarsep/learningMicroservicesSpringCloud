package jics.posts.service;

import jics.posts.model.Post;
import jics.posts.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements IPostService{
    @Autowired
    private IPostRepository repo;

    @Override
    public void savePost(Post post) {
        repo.save(post);
    }

    @Override
    public Post getPost(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @Override
    public void editPost(Long id, Post post) {
        Post updatedPost = this.getPost(id);
        if(updatedPost != null){
            updatedPost.setTitle(post.getTitle());
            updatedPost.setUserId(post.getUserId());
            repo.save(updatedPost);
        }else{
            System.out.println("El post recuperado es null");
        }
    }

    @Override
    public void deletePost(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Post> getPostsByUser(Long userId) {
        return repo.findPostByUserId(userId);
    }
}
