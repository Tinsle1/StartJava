package com.startjava.lesson_2_3_4.robot;

public class Jaeger {
    private String modelName;
    private String mark;
    private String origin;
    private String status;
    private float height;
    private float weight;
    private int strength;
    private int speed;

    // конструкторы 
    public Jaeger() {
    }

    public Jaeger(String modelName, String mark, String origin, String status,
            float height, float weight, int strength, int speed) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.status = status;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.speed = speed;
    }

    // геттеры и сеттеры
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight; 
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // методы
    public void run() {
        System.out.println("running");
    }

    public void swim() {
        System.out.println("swimming");
    }

    public void fight() {
        System.out.println("fighting");
    }

    public String toString() {
        return """
            Jaeger {
                Name: %s
                Mark: %s
                Origin: %s
                Status: %s
                Height: %f
                Weight: %f
                Strength: %d
                Speed: %d
            }""".formatted(modelName, mark, origin, status, height, weight, strength, speed);
    }
}  

  