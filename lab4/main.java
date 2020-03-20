package com.company;


import java.util.Scanner;
import java.util.Arrays;
import com.company.Student;
public class Main {
    public static void task1(Scanner in) {
        String s1, s2;
        s1 = in.nextLine();
        s2 = in.nextLine();
        char[] v1 = s1.toCharArray();
        char[] v2 = s2.toCharArray();
        Arrays.sort(v1);
        Arrays.sort(v2);
        s1 = new String(v1);
        s2 = new String(v2);
        if (s1.equals(s2)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static boolean check_pali(String s) {
        int L = s.length();
        for (int i = 0; i < L / 2; ++i) {
            if (s.charAt(i) != s.charAt(L - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void task2(Scanner in) {
        int N = in.nextInt();
        in.nextLine();
        String arr[] = new String[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = in.nextLine();
        }
        String pals[] = new String[N];
        int k = 0;
        for (int i = 0; i < N; ++i) {
            if (check_pali(arr[i])) {
                pals[k] = arr[i];
                ++k;
            }
        }
        int iMax = 0;
        for (int i = 1; i < k; ++i) {
            if (pals[i].length() > pals[iMax].length())
                iMax = i;
        }
        System.out.println(pals[iMax]);
    }

    public static String encode(StringBuilder s) {
        int x = Integer.parseInt(s.toString());
        if (x < 2) {
            return "1";
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0)
                return "1";
        }
        return "0";
    }

    public static void task3(Scanner in) {
        int N = in.nextInt();
        int M = in.nextInt();
        StringBuilder Mat[][] = new StringBuilder[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                int x = in.nextInt();
                Mat[i][j] = new StringBuilder();
                Mat[i][j].append(x);
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                Mat[i][j].replace(0, Mat[i][j].length(), encode(Mat[i][j]));
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if(Integer.parseInt(Mat[i][j].toString()) == 1) {
                    ++cnt;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        task1(in);

        task2(in);

        task3(in);

        in.close();
    }
}
