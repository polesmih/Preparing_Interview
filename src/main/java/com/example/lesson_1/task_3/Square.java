package com.example.lesson_1.task_3;

public class Square extends Figure{

    private float width;
    private float height;

    Square(float x, float y, float width, float height) {
        super(x, y);
        this.width = width;
        this.height = height;

    }

    @Override
    float getArea() {
        return width * height;
    }

    @Override
    public void getFigure() {
        System.out.println("This is a square with area - " + getArea() +
                " mm. and with perimeter - " + getPerimeter() + " mm.");;
    }

    public float getPerimeter() {
        return width * 2 + height * 2;
    }

}
