package com.company;


import java.util.Scanner;
import java.util.Arrays;
public class Main {


    public static void main(String[] args) {
        String str = "abc"; //TASK 1
        RandomOutTask rot = new RandomOutTask();
        OutTask ot = new OutTask(str);
        CounterOutTask cot = new CounterOutTask();
        rot.execute();
        ot.execute();
        cot.execute();
        cot.execute();
        cot.execute();
        System.out.println();
                            //TASK 2
        Album[] a = new Album[5];
        a[0] = new Album(2013, "abc", 3.5);
        a[1] = new Album(2012, "aaa", 3.5);
        a[2] = new Album(2012, "aaa", 4.5);
        a[3] = new Album(2012, "ddd", 10.5);
        a[4] = new Album(2012, "abc", 1.5);
        for (int i = 0; i < 5; ++i) {
            System.out.println(a[i]);
        }
        System.out.println();
        Arrays.sort(a);
        for (int i = 0; i < 5; ++i) {
            System.out.println(a[i]);
        }
    }
}
