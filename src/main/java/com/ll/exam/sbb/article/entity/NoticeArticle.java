package com.ll.exam.sbb.article.entity;

import com.ll.exam.sbb.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = ArticleType.Values.NOTICE)
@SuperBuilder
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class NoticeArticle extends Article {
    private int noticeDays;
    @ManyToOne
    @NotNull
    private Member approver;
}

