package com.company;


import java.util.Scanner;

public class Main {
    public static void t1(Scanner in) {
        int n = in.nextInt();
        for (int i = 0; i <= n; i +=2) {
            System.out.println(i);
        }
    }
    public static void t2(Scanner in) {
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(Math.max(a, b));
    }
    public static void t3(Scanner in) {
        int n = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                System.out.print(i);
                System.out.print(' ');
            }
        }
        System.out.println();
    }
    public static void t4(Scanner in) {
        int n = in.nextInt();
        long fact = 1;
        for (int i = 1; i <= n; ++i){
            fact *= i;
        }
        System.out.println(fact);
    }
    public static boolean t5(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int div = 3; div * div <= n; div += 2)
            if (n % div == 0) return false;
        return true;
    }
    public static void t6(Scanner in) {
        int a = in.nextInt();
        int b = in.nextInt();
        long aux = a;
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1)
                res *= aux;
            aux *= aux;
            b >>= 1;
        }
        System.out.println(res);
    }
    public static void t7(Scanner in){
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println(-1);
            return;
        }
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 3; i <= n; ++i) { // if n is 1 or 2 this will work just fine
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t1(in);
        t2(in);
        t3(in);
        t4(in);
        System.out.println(t5(13));
        t6(in);
        t7(in);
        in.close();
    }
}
