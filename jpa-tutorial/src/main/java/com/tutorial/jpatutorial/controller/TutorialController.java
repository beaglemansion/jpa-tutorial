package com.tutorial.jpatutorial.controller;

import com.tutorial.jpatutorial.domain.Member;
import com.tutorial.jpatutorial.dto.MemberDto;
import com.tutorial.jpatutorial.service.MemberService;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("member")
public class TutorialController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TutorialController.class);

    @Autowired
    private MemberService memberService;

    @GetMapping("list")
    public Map<String, Object> findAllMember() {
        Map<String, Object> response = new HashMap<>();

        List<Member> result = memberService.findAllMember();

        LOGGER.info(" TutorialController findAllMember result ::::: {}", result);

        response.put("result", result);

        return response;
    }

    @PostMapping("register")
    public String registerMember(@RequestBody Member member) throws Exception {

        LOGGER.info(" TutorialController registerMember  ::::: {}", member);

        return memberService.registerMember(member);
    }

    @GetMapping("test")
    public MemberDto test() {
        LOGGER.info(" TutorialController test  ::::: start ");
        MemberDto result = memberService.findOne();

        LOGGER.info(" TutorialController test  ::::: {}", result);
        return result;
    }


}
