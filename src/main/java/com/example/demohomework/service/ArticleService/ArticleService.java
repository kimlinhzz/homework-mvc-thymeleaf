package com.example.demohomework.service.ArticleService;

import com.example.demohomework.repository.model.Article;

import java.util.List;

public interface ArticleService  {
    void add(Article article);

    void update(int id,Article article);

    void delete(int id);

    List<Article> findAll();

    List<Article> showByPagination(int page,int limit);

    Article getArticle(int id);
}
