package com.jobportal.Jobportal.controller;


import com.jobportal.Jobportal.repository.PostRepository;
import com.jobportal.Jobportal.model.Post;
import com.jobportal.Jobportal.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository sRepo;

    @GetMapping("/posts")
    @CrossOrigin
    public List<Post> getAllPosts() {
      return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return sRepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

    @DeleteMapping("/delete-post/{id}")
    @CrossOrigin
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            // Return success message with HTTP status 200 OK
            return ResponseEntity.ok("Post deleted successfully");
        } else {
            // Return error message with HTTP status 404 NOT FOUND
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id: " + id);
        }
    }

    @GetMapping("/getapost/{id}")
    @CrossOrigin
    public Optional<Post> getPost(@PathVariable String id) {
        return repo.findById(id);
    }

//    public ResponseEntity<Void> updatePost(@PathVariable String id, @RequestParam String
//            desc , @RequestParam int exp , @RequestParam String profile, @RequestParam String techs){
//        repo.updatePost(id, profile, desc, techs);
//
//        return repo.;
//    }

}
