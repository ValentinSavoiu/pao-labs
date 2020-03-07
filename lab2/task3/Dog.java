package com.company;

public class Dog {
    private int age;
    private char gender;
    public void setAge(int newAge) {
        this.age = newAge;
    }
    public void setGender(char newGender) {
        this.gender = newGender;
    }
    public int getAge() {
        return this.age;
    }
    public char getGender() {
        return this.gender;
    }

    public void getOlder() {
        age++;
    }

    Dog(int Age, char Gender) {
        age = Age;
        gender = Gender;
    }
}
