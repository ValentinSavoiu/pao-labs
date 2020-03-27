package com.company;

public class CounterOutTask implements Task {

    static private int x = 0;
    @Override
    public void execute() {
        ++x;
        System.out.println(x);
    }
}
