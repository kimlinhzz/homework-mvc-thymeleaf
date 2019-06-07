package com.example.demohomework.service;

import com.example.demohomework.repository.ActicleRepositoryImp;
import com.example.demohomework.repository.articleRepository.ArticleRepository;
import com.example.demohomework.repository.model.Article;
import com.example.demohomework.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleServiceImp implements ArticleService {


    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void add(Article article) {
        articleRepository.add(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void update(int id, Article article) {
        articleRepository.update(id, article);
    }

    @Override
    public Article getArticle(int id) {
        return articleRepository.getArticle(id);
    }

    @Override
    public void delete(int id) {
        articleRepository.delete(id);
    }

    @Override
    public List<Article> showByPagination(int page, int limit) {

        return articleRepository.showByPagination(page, limit);
    }
}

