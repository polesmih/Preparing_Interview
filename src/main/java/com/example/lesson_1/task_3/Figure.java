package com.example.lesson_1.task_3;

abstract class Figure {
    //координаты точек
    private float x;
    private float y;

    public Figure(float x, float y) {
        this.x = x;
        this.y = y;
    }

    abstract float getArea();

    public void getFigure() {
        System.out.println("This is figure");
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
