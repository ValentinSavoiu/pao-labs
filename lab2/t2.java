package com.company;


import java.util.Scanner;

public class Main {
    public static void t2(Scanner in) {
        int n = in.nextInt();
        int []even = new int[n];
        int []odd = new int[n];
        int x, idxE = 0, idxO = 0;
        for (int idx = 0; idx < n; ++idx) {
            x = in.nextInt();
            if (x % 2 == 0)
                even[idxE++] = x;
            else
                odd[idxO++] = x;
        }
        if (idxE > idxO) {
            for (int idx = 0; idx < idxE; ++idx)
                System.out.print(Integer.toString(even[idx]) + ' ');
        }
        else {
            for (int idx = 0; idx < idxO; ++idx)
                System.out.print(Integer.toString(odd[idx]) + ' ');
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t2(in);
        in.close();
    }
}
