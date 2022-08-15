package com.ll.exam.sbb.article.controller;

import com.ll.exam.sbb.article.entity.Article;
import com.ll.exam.sbb.article.repository.BaseArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private BaseArticleRepository articleRepository;

    @GetMapping("/article/list")
    @ResponseBody
    public List showList() {
        return articleRepository.findAll();
    }

    @GetMapping("/article/detail")
    @ResponseBody
    public Article showDetail() {
        articleRepository.findAll();

        return articleRepository.findByTitle("제목3");
    }
}
