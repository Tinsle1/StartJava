package com.startjava.lesson_2_3.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setGender("male");
        wolfOne.setNickname("Auf");
        wolfOne.setWeight(40.2f);
        wolfOne.setAge(14);
        wolfOne.setColour("gray");

        System.out.println("Gender: " + wolfOne.getGender() + 
                "\nName: " + wolfOne.getNickname() +
                "\nWeight: " + wolfOne.getWeight() +
                "\nAge: " + wolfOne.getAge() +
                "\nColour " + wolfOne.getColour());

        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}
