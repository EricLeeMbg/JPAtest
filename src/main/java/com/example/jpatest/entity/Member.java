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
    @Column(nullable=false)
    private String id;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="member_id")
    private Collection<Phone> phone;

    private String username;

    public Collection<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone)  {
        this.phone = phone;
    }

    public void addPhone(Phone p)  {
        if  (phone==null)  {
            phone = new ArrayList<Phone>();
        }
        phone.add(p);
    }
    @Builder
    public Member(String id, String username, String no)  {
        this.id = id;
        this.username = username;
        this.addPhone(new Phone(no));

    }

    public Member() {

    }
}