package com.tutorial.jpatutorial.store;


import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;

import java.util.List;

public interface MemberStore {
    /**
     * 멤버 전체 조회
     */
    List<MemberTbo> readAllMember();

}
