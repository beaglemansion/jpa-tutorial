package com.tutorial.jpatutorial.domain;

import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import lombok.Data;

@Data
public class MemberDto {
    private String id;
    private String name;


    // entity -> dto ?
    // TODO entity와 DTO구분해서 사용하기 :: service & controller 에서 DTO 사용하도록 수정
    public MemberDto(MemberTbo memberTbo) {
        this.id = memberTbo.getId();
        this.name = memberTbo.getName();
    }
}
