package com.design.pattern.sealed.apiResponse;

public class main {

    // API 응답 처리 예시
    public void handleApiResponse(ApiResponse response) {
        if (response instanceof ApiResponse.Success<?> success) {
            Object data = success.data();
            if (data instanceof UserInfo user) {
                System.out.println("사용자 정보 조회 성공: " + user.username());
            } else {
                System.out.println("다른 타입의 데이터입니다: " + data.getClass().getName());
            }
        } else if (response instanceof ApiResponse.Error error) {
            System.out.println("오류 발생: " + error.message());
            System.out.println("오류 코드: " + error.errorCode());
        }
    }

    // 응답 생성 예시 - 서비스
    public ApiResponse getUserInfo(Long userId) {
        try {
            // API 호출 로직...
            UserInfo userInfo = new UserInfo(userId, "user123", "user@example.com");

            return new ApiResponse.Success<>(200, userInfo, "사용자 정보 조회 성공");
        } catch (Exception e) {
            return new ApiResponse.Error(
                    400,
                    "USER_NOT_FOUND",
                    "사용자 정보를 찾을 수 없습니다",
                    new ApiResponse.ErrorDetail("userId", "존재하지 않는 사용자 ID")
            );
        }
    }

    //sealed 사용해 정해진 응답 타입만 사용 가능 (예측 가능성 증가)
    //record 활용해 불변 객체로 안전한 데이터 모델 생성
    public static void main(String[] args) {
        main m = new main();
        m.handleApiResponse(m.getUserInfo(1L));
    }
}
