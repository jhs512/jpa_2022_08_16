package com.ll.exam.sbb;

import com.ll.exam.sbb.member.repository.BaseMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class MemberRepositoryTests {
    @Autowired
    private BaseMemberRepository memberRepository;

    @Test
    public void t1() {
        memberRepository.findAll();
    }
}
