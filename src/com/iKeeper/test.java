package com.iKeeper;
import java.util.Scanner;
public class test {
    public static void main(String[] args){
        try{
            int result = divide(10,2);
            System.out.println(result);
        }catch(NullPointerException e){
            System.err.println("Error " +e.getMessage());
        }

    }

public static int divide(int num1, int num2)throws NullPointerException{

    if(num2 == 2){
        throw new NullPointerException("Cannot divide by Zero");
    }
    return num1 / num2;
}
}