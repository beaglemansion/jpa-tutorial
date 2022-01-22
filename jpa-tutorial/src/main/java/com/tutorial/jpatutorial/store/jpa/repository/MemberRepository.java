package com.tutorial.jpatutorial.store.jpa.repository;

import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberTbo, String> {

    List<MemberTbo> findAll();

}
