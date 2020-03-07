package com.company;

public class Student {
    private int grade;
    private String name;

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        name = name;
    }
    public String toString() {
        return "Studentul " + name + " a obtinut nota " + Integer.toString(grade);
    }
    Student() {
        grade = 1;
        name = "UaeExarrqrAzd21";
    }
    Student(int Grade, String Name) {
        grade = Grade;
        name = Name;
    }
}
