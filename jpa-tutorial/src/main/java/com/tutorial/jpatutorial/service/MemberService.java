package com.tutorial.jpatutorial.service;

import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;

import java.util.List;

public interface MemberService {

    List<MemberTbo> findAllMember();
}
