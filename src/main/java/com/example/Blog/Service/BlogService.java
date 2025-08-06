package com.example.Blog.Service;

import com.example.Blog.Model.Blog;
import com.example.Blog.Repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepo blogRepo;

    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    public Optional<Blog> getBlogById(Integer id) {
        return blogRepo.findById(id);
    }

    public void saveBlog(Blog blog){
        if(blog == null){
            throw new IllegalArgumentException("Blog cannot be null");
        }
        if(blog.getId() == null){
            blog.setCreatedAt(LocalDateTime.now());
        }
        blogRepo.save(blog);
    }

    public void deleteBlog(Integer id) {
        blogRepo.deleteById(id);
    }
}
