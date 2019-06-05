package com.example.demohomework.repository.articleRepository;

import com.example.demohomework.repository.model.Article;

import java.util.List;

public interface ArticleRepository {

    void add(Article article);
    List<Article> findAll();
    void update(int id,Article article);
    Article getArticle(int id);
    void delete(int id);


}
