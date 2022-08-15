package com.ll.exam.sbb.article.repository;

import com.ll.exam.sbb.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ArticleRepository<T extends Article> extends JpaRepository<T, Long> {
    T findByTitle(String title);
}

