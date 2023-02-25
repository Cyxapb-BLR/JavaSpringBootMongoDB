package com.matskevich.joblisting.controllers;

import com.matskevich.joblisting.models.Post;
import com.matskevich.joblisting.repositories.PostRepository;
import com.matskevich.joblisting.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    PostRepository postRepository;

    SearchRepository searchRepository;

    @Autowired
    public PostController(PostRepository postRepository, SearchRepository searchRepository) {
        this.postRepository = postRepository;
        this.searchRepository = searchRepository;
    }

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return searchRepository.findByText(text);
    }
}
