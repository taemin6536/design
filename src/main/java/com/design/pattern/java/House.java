package com.design.pattern.java;

public record House(String table, String chair, String bed) {
    // 게터가지고있고,
    // 생성자도 가지고있고,
    // equals, hashCode, toString도 가지고있고,
    // 모든 필드가 final이고, private이다.
    // DTO, VO
    // request, response
    // pasing DTO     -> jackson LIB
    // json -> object 변환
}
