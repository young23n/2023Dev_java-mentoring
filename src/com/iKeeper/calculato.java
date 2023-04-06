package com.iKeeper;

public class calculato{
    int num1;
    int num2;
    String str;

    public calculato(int num1, int num2, String str) {
        this.num1 = num1;
        this.num2 = num2;
        this.str = str;
    }

    int add() {
        return num1 + num2;
    }

    int sub() {
        return num1 - num2;
    }

    int mul() {
        return num1 * num2;
    }

    int divi() {
        return num1 / num2;
    }

    void prin() {
        if (str.equals("+")) System.out.println(add());
        else if (str.equals("-")) System.out.println(sub());
        else if (str.equals("/")) System.out.println(divi());
        else if (str.equals("*")) System.out.println(mul());
    }
}
