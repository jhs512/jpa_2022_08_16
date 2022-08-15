package com.ll.exam.sbb;

import com.ll.exam.sbb.article.entity.Article;
import com.ll.exam.sbb.article.entity.FreeArticle;
import com.ll.exam.sbb.article.entity.NoticeArticle;
import com.ll.exam.sbb.article.repository.BaseArticleRepository;
import com.ll.exam.sbb.genfile.entity.GenFile;
import com.ll.exam.sbb.genfile.entity.GenFileType;
import com.ll.exam.sbb.genfile.repository.GenFileRepository;
import com.ll.exam.sbb.member.entity.Member;
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
public class GenFileRepositoryTests {
    @Autowired
    private GenFileRepository genFileRepository;

    @Autowired
    private BaseArticleRepository articleRepository;

    @Autowired
    private BaseMemberRepository memberRepository;

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

        GenFile genFile1 = GenFile
                .builder()
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .owner(member)
                .type2Code("common")
                .fileExtTypeCode("image")
                .fileExtType2Code("jpg")
                .fileSize(100)
                .fileNo(1)
                .fileExt("jpg")
                .fileDir("2022/08/15")
                .originFileName("무명.jpeg")
                .related(article3)
                .build();

        genFileRepository.save(genFile1);

        Article article4 = (Article)genFile1.getRelated();

        System.out.println(article4);

        GenFile genFile2 = genFileRepository.findById(1L).get();
        System.out.println(genFile2.getRelated());;
    }
}
