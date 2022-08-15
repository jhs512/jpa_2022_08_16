package com.ll.exam.sbb.genfile.entity;

import com.ll.exam.sbb.article.entity.Article;
import com.ll.exam.sbb.article.entity.FreeArticle;
import com.ll.exam.sbb.base.entity.BaseEntity;
import com.ll.exam.sbb.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SuperBuilder
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class GenFile extends BaseEntity {
    @ManyToOne
    private Member owner;
    @Column(name = "typeCode")
    private String typeCode;
    private String type2Code;
    private String fileExtTypeCode;
    private String fileExtType2Code;
    private int fileSize;
    private int fileNo;
    private String fileExt;
    private String fileDir;
    private String originFileName;

    @AnyMetaDef(
            idType = "long",
            metaType = "string",
            metaValues = {
                    @MetaValue(value = "MEMBER", targetEntity = Member.class),
                    @MetaValue(value = "ARTICLE", targetEntity = Article.class),
                    @MetaValue(value = "FREE_ARTICLE", targetEntity = FreeArticle.class)
            })
    @Any(metaColumn = @Column(name = "typeCode"))
    @JoinColumn(name = "related_id")
    private GenFileRelated related;
}
