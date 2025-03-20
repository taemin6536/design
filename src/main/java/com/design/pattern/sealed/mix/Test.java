package com.design.pattern.sealed.mix;

public class Test {
    public static void main(String[] args) {

    }
        public double calculateArea(Shape shape) {
            return switch (shape) {
                case Circle c -> Math.PI * c.radius() * c.radius();
                case Rectangle r -> r.width() * r.height();
            };
        }

    public double calculateArea2(Shape shape) {
        if (shape instanceof Circle c) {
            return Math.PI * c.radius() * c.radius();
        } else if (shape instanceof Rectangle r) {
            return r.width() * r.height();
        }

        return 0;
    }

    public double calculateArea3(Shape shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.radius() * c.radius();
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.width() * r.height();
        }

        return 0;
    }


}





