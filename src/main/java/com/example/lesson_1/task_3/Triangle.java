package com.example.lesson_1.task_3;

import java.awt.*;

public class Triangle extends Figure{

    Point a;
    Point b;
    Point c;

    public Triangle(float x, float y) {
        super(x, y);
    }

    float distance(Point a, Point b) {
        float dx = a.x - b.x;
        float dy = a.y - b.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    float getArea() {
        float ab = distance(a, b);
        float bc = distance(c, b);
        float ca = distance(a, c);
        float s = (ab + bc + ca) / 2;
        return (float) Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }

}
