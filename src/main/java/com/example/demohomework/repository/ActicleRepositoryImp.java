package com.example.demohomework.repository;

import com.example.demohomework.repository.articleRepository.ArticleRepository;
import com.example.demohomework.repository.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActicleRepositoryImp implements ArticleRepository {

    List<Article> articleList = new ArrayList<>();
    static int ID_COUNT = 1;
   public ActicleRepositoryImp(){
       for(int i=1 ; i<=2 ; i++){
           articleList.add(new Article("chan","popo","bla bla bla","unknow",i));
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
    public void update(int id,Article article) {
        System.out.println(article.getThumnail()+"throw from view");
//      articleList.set(id,article);
       for (Article article1 : articleList){

          if (article1.getId() == id){
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

        for (Article article : articleList){
            if (article.getId() == id){
                return article;
            }

        }
       return null;
    }

    @Override
    public void delete(int id) {
        for (Article article : articleList) {
            if (article.getId()==id) {
                articleList.remove(article);
                return;
            }

        }
   //     articleList.remove(1);
    }}



