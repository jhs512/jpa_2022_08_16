package com.ll.exam.sbb.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MemberRepository<T> extends JpaRepository<T, Integer> {

}

