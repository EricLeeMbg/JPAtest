package com.example.jpatest.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbrNo;
    @Column(nullable=true)
    private String id;

    private String username;

    public Member(String jung) {
    }
    @Builder
    public Member(String id, String username, String no)  {
        this.id = id;
        this.username = username;
    }
    public Member() {

    }
}