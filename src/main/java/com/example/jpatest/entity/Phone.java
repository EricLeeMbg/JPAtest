package com.example.jpatest.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="member_id")
    private int memberId;

    private String no;

    public Phone() {}

    @Builder
    public Phone(String no){
        this.no = no;
    }
}
