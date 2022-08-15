package com.ll.exam.sbb.member.entity;

import com.ll.exam.sbb.base.entity.BaseEntity;
import com.ll.exam.sbb.genfile.entity.GenFileRelated;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "memberType")
@SuperBuilder
@ToString(callSuper = true)
@Table(indexes = @Index(name = "idx__memberType", columnList = "memberType"))
@NoArgsConstructor
public abstract class Member extends BaseEntity implements GenFileRelated {
    @Enumerated(EnumType.STRING)
    @Column(name = "memberType", insertable = false, updatable = false)
    private MemberType memberType;
    @Column(unique = true)
    private String username;
    private String password;
}
