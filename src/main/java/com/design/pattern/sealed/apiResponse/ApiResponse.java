package com.design.pattern.sealed.apiResponse;

// API 응답의 기본 구조를 정의하는 sealed interface
public sealed interface ApiResponse permits ApiResponse.Success, ApiResponse.Error {

    // 성공 응답을 위한 record
    record Success<T>(
            int statusCode,
            T data,
            String message
    ) implements ApiResponse {}

    // 오류 응답을 위한 record
    record Error(
            int statusCode,
            String errorCode,
            String message,
            ErrorDetail detail
    ) implements ApiResponse {}

    // 오류 상세 정보를 위한 record
    record ErrorDetail(
            String field,
            String reason
    ) {}
}
