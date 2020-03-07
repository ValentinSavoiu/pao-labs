package com.company;


import java.util.Scanner;
import com.company.Dog;
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog(13, 'f');
        System.out.println(d.getAge());
        System.out.println(d.getGender());
        d.setGender('m');
        System.out.println(d.getGender());
        d.getOlder();
        System.out.println(d.getAge());
    }
}
