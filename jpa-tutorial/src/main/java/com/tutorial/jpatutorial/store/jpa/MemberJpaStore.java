package com.tutorial.jpatutorial.store.jpa;

import com.tutorial.jpatutorial.domain.Member;
import com.tutorial.jpatutorial.dto.MemberDTO;
import com.tutorial.jpatutorial.dto.MemberDTO;
import com.tutorial.jpatutorial.store.MemberStore;
import com.tutorial.jpatutorial.store.jpa.repository.MemberRepository;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import com.tutorial.jpatutorial.store.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemberJpaStore implements MemberStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberJpaStore.class);

    @Autowired
    private MemberRepository repository;

    @Override
    public List<Member> readAllMember() {
        List<MemberTbo> tbos = repository.findAll();

        LOGGER.info("MemberJpaStore findAllMember result ::::: {}", tbos);

        return tbos.stream().map(MemberTbo::toDomain).collect((Collectors.toList()));
    }

    @Override
    public String create(Member member) {
        MemberTbo memberTbo = new MemberTbo(member); // 맞는지 확인필요
        repository.save(memberTbo);

        LOGGER.info("MemberJpaStore create  ::::: {}", memberTbo);

        return member.getId();
    }

    @Override
    public Member readById(String id) {
        MemberTbo memberTbo = repository.findById(id).orElse(null);

        if (memberTbo == null) {
            return null;
        }
        return memberTbo.toDomain();
    }

    /**
     * mapstruct테스트
     * @return
     */
    @Override
    public MemberDTO readOne() {
        MemberTbo tbo = repository.findById("1").orElse(null);
        LOGGER.info("MemberJpaStore readOne  ::::: {}", tbo);

        MemberDTO result = MemberMapper.INSTANCE.toMemberDto_4(tbo);

        return result;
    }
    /**
     * mapstruct테스트
     * @return
     */
    @Override
    public List<MemberDTO> readMany() {
        List<MemberTbo> tbo = repository.findAll();
        LOGGER.info("MemberJpaStore readMany  ::::: {}", tbo);

        List<MemberDTO> result = MemberMapper.INSTANCE.toMemberDto_3(tbo);
        return result;
    }
}
