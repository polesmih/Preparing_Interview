package com.example.lesson_1.task_3;

public class Circle extends Figure {

    public static final float PI = 3.14f;
    float radius;

    public Circle(float x, float y) {
        super(x, y);
    }

    float getArea() {
        return PI * (radius * radius);
    }
}
