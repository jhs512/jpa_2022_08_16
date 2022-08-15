package com.ll.exam.sbb.article.repository;

import java.util.List;

public interface ArticleRepositoryCustom<T> {
    List<T> search(int page);
}
