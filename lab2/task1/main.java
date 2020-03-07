package com.company;


import java.util.Scanner;

public class Main {
    public static void t1(Scanner in) {
        int n = in.nextInt();
        int []array = new int[n];
        int x, idx = 0, sum = 0;
        while ((x = in.nextInt()) != -1 && idx < n) {
            array[idx] = x;
            ++idx;
            sum += x;
        }
        System.out.println(sum * 1.0 / idx);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t1(in);
        in.close();
    }
}
