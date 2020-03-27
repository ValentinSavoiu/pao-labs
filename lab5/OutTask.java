package com.company;

public class OutTask implements Task {

    private String mesaj;
    OutTask(String msj) {
        this.mesaj = msj;
    }
    @Override
    public void execute() {
        System.out.println(this.mesaj);
    }
}
