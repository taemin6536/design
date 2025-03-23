package com.design.pattern.sealed.mix;

// sealed 클래스로 데이터 타입 계층 구조 정의
sealed interface Shape permits Circle, Rectangle, abc {}
