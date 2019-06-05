package com.example.demohomework.service.ArticleService;

import com.example.demohomework.repository.model.Article;

import java.util.List;

public interface ArticleService  {
    void add(Article article);
    List<Article> findAll();
    void update(int id,Article article);
    Article getArticle(int id);
    void delete(int id);
}
