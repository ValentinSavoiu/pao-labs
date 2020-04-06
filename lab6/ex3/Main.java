package com.company;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

public class Main {


    public static void main(String[] args) throws IOException {
        int cntMinor = 0;
        FileInputStream fis = new FileInputStream("clienti.txt");
        Scanner in = new Scanner(System.in);
        byte[] buf = new byte[1000];
        fis.read(buf, 0, 1000);
        fis.close();
        String aux = new String(buf);
        String[] s = aux.split("\n");
        ArrayList<String> clientiMajori = new ArrayList<String>();
        int N = s.length;
        for (int i = 0; i < N; ++i) {
            String[] client = s[i].split(" ");
            try {
                client[2] = client[2].strip();
                if (Integer.parseInt(client[2]) < 18) {
                    cntMinor++;
                } else {
                    clientiMajori.add(s[i]);
                }
            }
            catch (Exception e) {
                continue;
            }
        }
        System.out.println("Clienti minori: " + cntMinor);
        N = clientiMajori.size();
        System.out.println("Clienti majori: " + N);
        for (int i = 0; i < N; ++i) {
            System.out.println(clientiMajori.get(i));
        }
    }
}
