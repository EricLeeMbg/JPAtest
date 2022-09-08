package com.example.jpatest;

import com.example.jpatest.entity.Member;
import com.example.jpatest.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Test Method 순서를 위해 추가
@Slf4j
class JpAtestApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Order(1)
    void save() { // User 객체를 생성하여 User 테이블에 저장한다.
        Member user = new Member();
        user.setUsername("kim ori");
        memberRepository.save(user);

        user = new Member();
        user.setUsername("lee ori");
        memberRepository.save(user);

        user = new Member();
        user.setUsername("kim ental");
        memberRepository.save(user);

        user = new Member();
        user.setUsername("lee ental");
        memberRepository.save(user);

        user = new Member();
        user.setUsername("kim samuel");
        memberRepository.save(user);
    }

    @Test
    @Order(2)
    void select() { // 저장된 데이터 모두를 Spring JPA에 미리 구현된 findAll 명령을 통해 불러온다.
        List<Member> userList = memberRepository.findAll();
        for(Member u : userList) log.info("[FindAll]: " + u.getId() + " | " +u.getUsername());
    }


    @Test
    @Order(3)
    void select2() { // Like 검색으로 2개만 값을 가져오는 내가 작성한 명령을 실행해본다.
        /*List<Member> userList = memberRepository.findFirst2ByUsernameLikeOrderByIdDesc("kim%");
        for(Member u : userList) log.info("[FindSome]: "  + u.getId() + " | " +u.getUsername());*/
    }

}
