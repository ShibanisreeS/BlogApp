package com.example.Blog.Controller;

import com.example.Blog.Model.Blog;
import com.example.Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public List<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public Optional<Blog> getBlogById(@PathVariable Integer id){
        return blogService.getBlogById(id);
    }

    @PostMapping("/blogs")
    public String saveBlog(@RequestBody Blog blog){
        blogService.saveBlog(blog);
        return "Blog saved successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return "Blog was deleted successfully";
    }
}
