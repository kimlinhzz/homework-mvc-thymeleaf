package com.example.demohomework.controller;

import com.example.demohomework.repository.model.Article;
import com.example.demohomework.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    ArticleService articleService;

    @GetMapping({"/index", "/"})
    public String getIndex(ModelMap modelMap) {
        System.out.println(articleService.findAll() + "hello");
        modelMap.addAttribute("articles", articleService.findAll());
        return "index";
    }


    @GetMapping("/formAdd")
    public String getFormAdd(ModelMap modelMap) {
        Article article = new Article();
        article.setId(articleService.findAll().size() + 1);
        modelMap.addAttribute("article", article);
        return "form-add";
    }

    @PostMapping("/add")
    public String addData(@Valid @ModelAttribute Article article, BindingResult result, @RequestParam("file") MultipartFile file) {
        if (result.hasErrors()) {

            System.out.println("error");
            return "form-add";
        } else {


        System.out.println(configImage(file));
        article.setThumnail(configImage(file));
        articleService.add(article);
        return "redirect:/";}
    }

    @GetMapping("/delete")
    public String deleteData(@RequestParam("id") int articleID) {
        System.out.println(articleID);
        articleService.delete(articleID);
        return "redirect:/";
    }

    @GetMapping("/formUpdate")
    public String getFormUpdate(ModelMap modelMap, @RequestParam("id") int articleID) {
        modelMap.addAttribute("article", articleService.getArticle(articleID));
        System.out.println(articleService.getArticle(articleID));
        return "form-update";
    }

    @PostMapping("/update")
    public String updateData(@RequestParam("id") int articleId, @ModelAttribute Article article, @RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        if (!file.isEmpty()) {
            System.out.println(file.getOriginalFilename() + "update");
            article.setThumnail(configImage(file));
            articleService.update(articleId, article);
            return "redirect:/";
        } else {
            System.out.println("processing");
            return "redirect:/";
        }
    }

    @GetMapping("/view")
    public String viewData(@RequestParam("id") int articleId, ModelMap modelMap) {
        modelMap.addAttribute("article", articleService.getArticle(articleId));
        return "view";
    }


    private String configImage(MultipartFile file) {
        UUID random = UUID.randomUUID();
        String fileName;
        if (file.isEmpty()) {
            fileName = "default.png";
        } else {
            String f = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            System.out.println(random + f);
            fileName = random + f;
        }
        try {
            Files.copy(file.getInputStream(), Paths.get("src/main/resources/thumnail/", fileName));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
    //Fragment

    @GetMapping("/frag1")
    public String getFrag(){
        return "fragment/ajax-fragment::header1";
    }
}

