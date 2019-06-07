package com.example.demohomework.repository;

import com.example.demohomework.repository.articleRepository.ArticleRepository;
import com.example.demohomework.repository.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActicleRepositoryImp implements ArticleRepository {
    static private int page;
    static public int lastPage;
    static public int currentPage = 1;
    static private int nextpage;
    static private int limit;


    List<Article> articleList = new ArrayList<>();

    public ActicleRepositoryImp() {
        for (int i = 1; i <= 70; i++) {
            articleList.add(new Article("chan", "popo", "bla bla bla", "unknow", i));
        }
    }

    @Override
    public void add(Article article) {

        articleList.add(article);
    }

    @Override
    public List<Article> findAll() {
        return articleList;
    }

    @Override
    public void update(int id, Article article) {
        System.out.println(article.getThumnail() + "throw from view");
//      articleList.set(id,article);
        for (Article article1 : articleList) {

            if (article1.getId() == id) {
                article1.setTitle(article.getTitle());
                article1.setAurthor(article.getAurthor());
                article1.setDescription(article.getDescription());
                article1.setThumnail(article.getThumnail());
                return;
            }
        }
    }

    @Override
    public Article getArticle(int id) {

        for (Article article : articleList) {
            if (article.getId() == id) {
                return article;
            }

        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (Article article : articleList) {
            if (article.getId() == id) {
                articleList.remove(article);
                return;
            }

        }
        //     articleList.remove(1);
    }

    @Override
    public List<Article> showByPagination(int page, int limit) {
        List temp;
//      ActicleRepositoryImp.lastPage=(articleList.size()%limit==0)?articleList.size()/limit:(articleList.size()/limit)+1;
        ActicleRepositoryImp.currentPage = page;
        ActicleRepositoryImp.page = page;
        ActicleRepositoryImp.lastPage = (int) (Math.ceil(articleList.size() / (double) limit));
        int startPage = (page - 1) * limit;
        int endPage = startPage + limit;

        if (endPage >= articleList.size()) {
            endPage = articleList.size();
        }
        temp = articleList.subList(startPage, endPage);
        return temp;
    }
}



