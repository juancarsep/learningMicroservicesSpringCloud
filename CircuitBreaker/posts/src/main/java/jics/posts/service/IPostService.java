package jics.posts.service;

import jics.posts.model.Post;

import java.util.List;

public interface IPostService {

    public void savePost(Post post);
    public Post getPost(Long id);
    public List<Post> getAllPosts();
    public void editPost(Long id, Post post);
    public void deletePost(Long id);

    public List<Post> getPostsByUser(Long userId);
}
