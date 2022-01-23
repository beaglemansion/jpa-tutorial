package com.tutorial.jpatutorial.service.logic;

import com.tutorial.jpatutorial.domain.Member;
import com.tutorial.jpatutorial.service.MemberService;
import com.tutorial.jpatutorial.store.MemberStore;
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
    public List<Member> findAllMember() {

        List<Member> result = memberStore.readAllMember();
        LOGGER.info("MemberServiceLogic findAllMember result ::::: {}", result);

        return result;
    }

    @Override
    public String registerMember(Member member) throws Exception {

        if (this.existMemberById(member.getId())) {
            LOGGER.info("존재하는 멤버");
            throw new Exception("존재하는 멤버입니다");
        }

        LOGGER.info("MemberServiceLogic registerMember result ::::: {}", member);

        return memberStore.create(member);
    }

    private boolean existMemberById(String id) {
        return memberStore.readById(id) != null;
    }
}
