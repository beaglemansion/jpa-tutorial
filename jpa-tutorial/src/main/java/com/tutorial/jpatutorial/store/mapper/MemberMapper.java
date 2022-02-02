package com.tutorial.jpatutorial.store.mapper;

import com.tutorial.jpatutorial.dto.AdditionalInfoDTO;
import com.tutorial.jpatutorial.dto.MemberDTO;
import com.tutorial.jpatutorial.store.jpa.repository.entity.MemberTbo;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    // MemberTbo = MemberDto 일 때
    MemberDTO toMemberDto(MemberTbo memberTbo);

    // MemberTbo != MemberDto 일 때
    @Mapping(source = "id", target = "memberId")
    @Mapping(source = "name", target = "memberName")
    MemberDTO toMemberDto_1(MemberTbo memberTbo);

    ////////////////////////////////////////////////////////////
    @Named("E2D")
    @Mapping(source = "id", target = "memberId")
    @Mapping(source = "name", target = "memberName")
    @Mapping(source = "age", target = "memberAge")
    @Mapping(source = "team", target = "memberGroup")
    @Mapping(target = "memberGender", ignore = true)
    @Mapping(target = "createdat", expression = "java(createDatetime())") // 구현한 메서드 사용
    MemberDTO toMemberDto_2(MemberTbo memberTbo);

    // 커스텀 메서드 직접 구현
    default String createDatetime() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일"); //원하는 데이터 포맷 지정
        String strNowDate = simpleDateFormat.format(now);
        return  strNowDate;
    }

    ////////////////////////////////////////////////////////////////////
    // Collection 매핑 - List<Object>
    @IterableMapping(qualifiedByName ="E2D")
    List<MemberDTO> toMemberDto_3(List<MemberTbo> memberTbo);


    ///////////////////////////////////////////////////////////////////
    // 객체를 속성에 추가
    @Mapping(source = "id", target = "memberId")
    @Mapping(source = "name", target = "memberName")
    @Mapping(target = "additionalInfoDTO", expression = "java(toAdditionalInfoDTO(memberTbo))")
    MemberDTO toMemberDto_4(MemberTbo memberTbo);

    // 커스텀 메서드 1
    @Mapping(source = "age", target = "memberAge")
    @Mapping(source = "team", target = "memberGroup")
    @Mapping(source = "gender", target = "memberGender")
    @Mapping(target = "createdat", expression = "java(createDatetime())") // 구현한 메서드 사용
    AdditionalInfoDTO toAdditionalInfoDTO(MemberTbo memberTbo);

    /////////////////////////////////////////////////////////////////////

}
