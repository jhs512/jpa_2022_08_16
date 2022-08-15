package com.ll.exam.sbb.article.repository;

import com.ll.exam.sbb.article.entity.QArticle;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleRepositoryImpl<T> implements ArticleRepositoryCustom<T> {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<T> search(int page) {
        return (List<T>) jpaQueryFactory
                .select(QArticle.article)
                .from(QArticle.article)
                .offset(page * 10)
                .limit(10)
                .fetch();
    }
}

