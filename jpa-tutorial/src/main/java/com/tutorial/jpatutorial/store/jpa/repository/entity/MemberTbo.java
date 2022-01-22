package com.tutorial.jpatutorial.store.jpa.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "member") // JPQL의 쿼리문에 사용되는 테이블이름. 명시하지 않으니 SELECT 작동X
public class MemberTbo {

    @Id
    private String id;
    private String name;

    public MemberTbo() {

    }
}
