package com.tutorial.jpatutorial.store.mapper;

import com.tutorial.jpatutorial.dto.MemberDto;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    // MemberTbo = MemberDto 일 때
    MemberDto toMemberDto(MemberTbo memberTbo);

    // MemberTbo != MemberDto 일 때
    @Mapping(source = "id", target = "memberId")
    @Mapping(source = "name", target = "memberName")
    MemberDto toMemberDto_1(MemberTbo memberTbo);


    @Mapping(source = "id", target = "memberId")
    @Mapping(source = "name", target = "memberName")
    @Mapping(source = "age", target = "memberAge")
    @Mapping(source = "team", target = "memberGroup")
    @Mapping(target = "memberGender", ignore = true)
    @Mapping(target = "createdat", expression = "java(createDatetime())") // 구현한 메서드 사용
    MemberDto toMemberDto_2(MemberTbo memberTbo);

    // 특수 메서드 직접 구현
    default String createDatetime() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일"); //원하는 데이터 포맷 지정
        String strNowDate = simpleDateFormat.format(now);
        return  strNowDate;
    }


}
