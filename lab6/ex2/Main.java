package com.company;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

public class Main {


    public static void main(String[] args) throws IOException {
       int cntBadPass = 0, cntBadUser = 0;
       FileInputStream fis = new FileInputStream("parole.txt");
       Scanner in = new Scanner(System.in);
       byte[] buf = new byte[1000];
       boolean badPass = false;
       fis.read(buf, 0, 1000);
       fis.close();
       String aux = new String(buf);
       String[] s = aux.split("[\n ]");
       int N = s.length;
       while (true) {
           System.out.println("Introduceti userul si parola, pe cate o linie");
           String user, pass;
           user = in.nextLine();
           pass = in.nextLine();
           badPass = false;
           for (int i = 0; i < N; i = i + 2) {
               String fileUser = s[i].strip();
               String filePass = s[i + 1].strip();
               if (user.equals(fileUser) && pass.equals(filePass)) {
                   System.out.println("Access granted");
                   return;
               }
               if (user.equals(fileUser) && !pass.equals(filePass))
                   badPass = true;
           }
           System.out.println("User sau parola gresita");
           if (badPass == true) {
               cntBadPass++;
           }
           else {
               cntBadUser++;
           }
           if (cntBadPass == 3) {
               System.out.println("Cont blocat");
               return;
           }
           if (cntBadUser == 5) {
               System.out.println("Nu ai cont. Inregistreaza-te");
               return;
           }
       }
    }
}
