package com.tutorial.jpatutorial.service.logic;

import com.tutorial.jpatutorial.controller.TutorialController;
import com.tutorial.jpatutorial.service.MemberService;
import com.tutorial.jpatutorial.store.MemberStore;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceLogic implements MemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceLogic.class);

    @Autowired
    private MemberStore memberStore;

    @Override
    public List<MemberTbo> findAllMember() {
        return memberStore.readAllMember();
    }
}
