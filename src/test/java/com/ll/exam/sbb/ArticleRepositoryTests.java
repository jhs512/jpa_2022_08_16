package com.ll.exam.sbb;

import com.ll.exam.sbb.article.entity.Article;
import com.ll.exam.sbb.article.entity.FreeArticle;
import com.ll.exam.sbb.article.entity.NoticeArticle;
import com.ll.exam.sbb.article.repository.BaseArticleRepository;
import com.ll.exam.sbb.member.entity.NormalMember;
import com.ll.exam.sbb.member.repository.BaseMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootTest
@ActiveProfiles("test")
public class ArticleRepositoryTests {
    @Autowired
    private BaseMemberRepository memberRepository;

    @Autowired
    private BaseArticleRepository articleRepository;

    @Test
    public void t1() {
        NormalMember member = NormalMember
                .builder()
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .username("제목")
                .password("내용")
                .build();
        memberRepository.save(member);

        Article article1 = FreeArticle
                .builder()
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .title("제목1")
                .body("내용2")
                .writer(member)
                .build();

        Article article2 = FreeArticle
                .builder()
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .title("제목2")
                .body("내용2")
                .writer(member)
                .build();

        Article article3 = NoticeArticle
                .builder()
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .title("제목3")
                .body("내용3")
                .writer(member)
                .approver(member)
                .build();

        articleRepository.saveAll(Arrays.asList(article1, article2, article3));
        articleRepository.findAll();

        Article article = articleRepository.findById(3L).get();

        System.out.println(((NoticeArticle) article));
    }

    @Test
    public void t2() {
        articleRepository.search(1);
    }
}
