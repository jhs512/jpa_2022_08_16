package com.ll.exam.sbb.member.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = MemberType.Values.NORMAL)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
public class NormalMember extends Member {

}
