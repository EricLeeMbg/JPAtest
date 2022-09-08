package com.example.jpatest.repository;

import com.example.jpatest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
/*
    List<Member> findFirst2ByUsernameLikeOrderByIdDesc(String username);
    List<Member> findById(String id);

    List<Member> findByUsername(String username);

    //like검색도 가능
    List<Member> findByUsernameLike(String keyword);*/
}