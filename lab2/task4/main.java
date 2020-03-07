package com.company;


import java.util.Scanner;
import com.company.Student;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Student[] stud_array = new Student[n];
        for (int idx = 0; idx < n; ++idx) {
            String input = in.nextLine();
            String[] tokens = input.split(" ");
            stud_array[idx] = new Student( Integer.parseInt(tokens[1]), tokens[0]);
        }
        for (int idx = 0; idx < n; ++idx) {
            System.out.println(stud_array[idx]);
        }
    }
}
