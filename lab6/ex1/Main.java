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
       int x, y;
       FileOutputStream fis = new FileOutputStream("1.txt", true);
       Scanner in = new Scanner(System.in);
       while (true) {
           try {
               x = in.nextInt();
               y = in.nextInt();
               if (x >= y) throw new MyException("Primul numar este mai mare sau egal ca cel de-al doilea:\n");
               String s = (x + " " + y + "   ");
               fis.write(s.getBytes());
           }
           catch (MyException e){
                System.out.print(e);
           }
           catch (Exception e) {
               break;
           }
       }
       fis.close();
    }
}
