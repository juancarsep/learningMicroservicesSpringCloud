package jics.posts.controller;

import jakarta.ws.rs.Path;
import jics.posts.model.Post;
import jics.posts.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private IPostService service;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return service.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id){
        return service.getPost(id);
    }

    @GetMapping("/posts/getpostsbyuser/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId){
        System.out.println("estoy en el puerto " + serverPort);
        return service.getPostsByUser(userId);
    }

    @PostMapping("/posts")
    public void savePost(@RequestBody Post post){
        service.savePost(post);
    }

    @PutMapping("/posts/{id}")
    public void editPost(@PathVariable Long id,
                         @RequestBody Post post){
        service.editPost(id, post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id){
        service.deletePost(id);
    }
}
