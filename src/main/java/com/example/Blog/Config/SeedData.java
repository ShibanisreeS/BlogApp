package com.example.Blog.Config;

import com.example.Blog.Model.Account;
import com.example.Blog.Model.Blog;
import com.example.Blog.Service.AccountService;
import com.example.Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        Account account01 = new Account();
        account01.setEmail("shibanisree3@gmail.com");
        account01.setPassword("Shibani@1502");
        account01.setFirstName("Shibani");
        accountService.saveAccount(account01);

        Account account02 = new Account();
        account02.setEmail("pshanthip2016@gmail.com");
        account02.setPassword("Shanthi@4716");
        account02.setFirstName("Shanthi");
        accountService.saveAccount(account02);

        List<Blog> blogs = blogService.getAllBlogs();

        if (blogs.isEmpty()){
            Blog blog01 = new Blog();
            blog01.setTitle("Blog01");
            blog01.setContent("Blog01 body.....");
            blog01.setAccount(account01);
            blogService.saveBlog(blog01);

            Blog blog02 = new Blog();
            blog02.setTitle("Blog02");
            blog02.setContent("Blog02 body.....");
            blog02.setAccount(account02);
            blogService.saveBlog(blog02);
        }

    }
}
