package com.ll.exam.sbb.article.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = ArticleType.Values.FREE)
@SuperBuilder
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class FreeArticle extends Article {

}
