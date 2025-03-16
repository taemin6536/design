package com.design.pattern.sealed.mix;

import com.design.pattern.sealed.mix.Shape;

// record 클래스로 데이터 구조 선언 (자동으로 final이라 더 이상 상속 불가)
public record Circle(double radius) implements Shape {}
