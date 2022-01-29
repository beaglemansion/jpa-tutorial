package com.tutorial.jpatutorial.service;

import com.tutorial.jpatutorial.domain.Member;
import com.tutorial.jpatutorial.dto.MemberDto;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;

import java.util.List;

public interface MemberService {

    /**
     * 멤버 전제 조회
     * @return
     */
    List<Member> findAllMember();

    /**
     * 멤버 등록
     * @param member
     * @return
     */
    String registerMember(Member member) throws Exception;

    /**
     * mapstruct 테스트
     * @return
     */
    MemberDto findOne();
}
