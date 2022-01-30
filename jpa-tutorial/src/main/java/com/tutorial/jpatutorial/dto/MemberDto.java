package com.tutorial.jpatutorial.dto;

import lombok.Data;

import java.util.Date;

/**
 * TBO로부터 데이터를 넘겨받고
 * DTO, VO 역할하는 객체
 * Service, Controller에서 사용한다
 */
@Data
public class MemberDto {
//    private String id;
//    private String name;

    private int memberId;
    private String memberName;

    private int memberAge;
    private String memberGroup; // target
    private String memberGender; // ignore

    private String createdat; // expression
}
