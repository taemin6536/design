package com.design.pattern.sealed.apiResponse;

// 사용자 정보 데이터 클래스
public record UserInfo(
        Long id,
        String username,
        String email
) {}

