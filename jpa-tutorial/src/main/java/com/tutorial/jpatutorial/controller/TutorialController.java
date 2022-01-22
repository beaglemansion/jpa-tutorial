package com.tutorial.jpatutorial.controller;

import com.tutorial.jpatutorial.service.MemberService;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("member")
public class TutorialController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TutorialController.class);

    @Autowired
    private MemberService memberService;

    @GetMapping("list")
    public List<MemberTbo> findAllMember() {
        List<MemberTbo> result = memberService.findAllMember();

        LOGGER.info("findAllMember result ::::: {}", result);

        return result;
    }

}
