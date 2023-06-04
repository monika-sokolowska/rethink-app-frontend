package com.example.backend.controller;

import com.example.backend.model.Article;
import com.example.backend.model.User;
import com.example.backend.repository.ArticleRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewArticle (@RequestParam String title
            , @RequestParam String text) {

        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        articleRepository.save(article);
        return "Saved";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
