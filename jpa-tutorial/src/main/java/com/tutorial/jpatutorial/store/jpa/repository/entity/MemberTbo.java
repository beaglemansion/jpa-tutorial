package com.tutorial.jpatutorial.store.jpa.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class MemberTbo {

    @Id
    private String id;

    private String name;
}
