package com.tutorial.jpatutorial.store.jpa.repository.entity;

import com.tutorial.jpatutorial.domain.Member;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 테이블 매핑
 * 가장 먼저 DB접근하여 데이터를 담아올 때 쓰는 객체
 * Store에서 사용한다
 * 이후 DTO에게 데이터를 넘겨준다
 */
@Data
@Entity
@Table(name = "member") // JPQL의 쿼리문에 사용되는 테이블이름. 명시하지 않으니 테이블명을 클래스명(MemberTbo)으로 사용해버림
public class MemberTbo {

    @Id
    private String id;
    private String name;

    // TBO -> DTO
    public Member toDomain() {
        Member member = new Member();
        BeanUtils.copyProperties(this, member);

        return member;
    }

    // 이 생성자가 없으면 에러발생
    public MemberTbo() {
    }

    public MemberTbo(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }

}
