package com.jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // JPA 내장 타입
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // JPA가 필요로 함 -> 리플렉션 등등 에서
    // 외부에서 최대한 접근 못하면서 JPA가 허용하는 Protected를 사용함으로써 가능하면 기본 생성자는 건드리지 말자!로 인식
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
