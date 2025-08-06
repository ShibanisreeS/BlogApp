package com.example.Blog.Config;

import com.example.Blog.Model.Blog;
import com.example.Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private BlogService blogService;

    @Override
    public void run(String... args) throws Exception {
        List<Blog> blogs = blogService.getAllBlogs();

        if (blogs.isEmpty()){
            Blog blog01 = new Blog();
            blog01.setTitle("Blog01");
            blog01.setContent("Blog01 body.....");
            blogService.saveBlog(blog01);

            Blog blog02 = new Blog();
            blog02.setTitle("Blog02");
            blog02.setContent("Blog02 body.....");
            blogService.saveBlog(blog02);
        }

    }
}
