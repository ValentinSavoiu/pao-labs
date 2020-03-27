package com.company;

public class RandomOutTask implements Task{
    private int rand;
    RandomOutTask() {
        this.rand = (int) Math.round(Math.random() * 100);
    }
    @Override
    public void execute() {
        System.out.println(this.rand);
    }
}
