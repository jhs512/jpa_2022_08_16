package com.ll.exam.sbb.article.entity;

import com.ll.exam.sbb.base.entity.BaseEntity;
import com.ll.exam.sbb.genfile.entity.GenFileRelated;
import com.ll.exam.sbb.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "articleType")
@SuperBuilder
@ToString(callSuper = true)
@Table(indexes = @Index(name = "idx__articleType", columnList = "articleType"))
@Getter
@NoArgsConstructor
public abstract class Article extends BaseEntity implements GenFileRelated {
    @Enumerated(EnumType.STRING)
    @Column(name = "articleType", insertable = false, updatable = false)
    private ArticleType articleType;
    @ManyToOne
    @NotNull
    private Member writer;
    private String title;
    private String body;
}
