package com.jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // JPA 내장타입 포함
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member") // 1:n 관계 (mappedBy: order table의 member에 의해서 매핑)
    private List<Order> orders = new ArrayList<>();

}