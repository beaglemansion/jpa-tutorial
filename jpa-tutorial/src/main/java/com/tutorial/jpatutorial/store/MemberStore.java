package com.tutorial.jpatutorial.store;


import com.tutorial.jpatutorial.domain.Member;
import com.tutorial.jpatutorial.dto.MemberDto;

import java.util.List;

public interface MemberStore {
    /**
     * 멤버 전체 조회
     * @return
     */
    List<Member> readAllMember();

    /**
     * 멤버 등록
     * @param member
     * @return
     */
    String create(Member member);

    /**
     * 멤버조회 by id
     * @param id
     * @return
     */
    Member readById(String id);


    /**
     * mapstruct테스트
     */
    MemberDto readOne();
}
