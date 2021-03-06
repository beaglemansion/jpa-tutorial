package com.tutorial.jpatutorial.domain;

import lombok.Data;

/**
 * TBO로부터 데이터를 넘겨받고
 * DTO, VO 역할하는 객체
 * Service, Controller에서 사용한다
 */
@Data
public class Member {
    private String id;
    private String name;

}
