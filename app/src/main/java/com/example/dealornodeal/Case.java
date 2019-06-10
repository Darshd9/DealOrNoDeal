package com.example.dealornodeal;

public class Case {

    private int num;
    private int value;
    private int status;

    public Case(int num, int value, int status){
        this.num = num;
        this.value = value;
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public int getStatus() {
        return status;
    }

    public int getValue() {
        return value;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return " $ " + value;
    }
}
