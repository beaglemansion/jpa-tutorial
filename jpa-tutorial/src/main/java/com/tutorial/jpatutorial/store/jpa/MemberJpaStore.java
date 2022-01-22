package com.tutorial.jpatutorial.store.jpa;

import com.tutorial.jpatutorial.store.MemberStore;
import com.tutorial.jpatutorial.store.jpa.repository.MemberRepository;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberJpaStore implements MemberStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberJpaStore.class);

    @Autowired
    private MemberRepository repository;

    @Override
    public List<MemberTbo> readAllMember() {
        List<MemberTbo> tbos = repository.findAll();
        return tbos;
    }
}
