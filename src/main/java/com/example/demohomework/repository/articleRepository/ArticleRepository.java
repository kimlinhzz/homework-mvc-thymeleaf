package com.example.demohomework.repository.articleRepository;

import com.example.demohomework.repository.model.Article;

import java.util.List;

public interface ArticleRepository {

    void add(Article article);

    void update(int id,Article article);

    void delete(int id);

    List<Article> showByPagination(int page,int limit);

    List<Article> findAll();

    Article getArticle(int id);
}
