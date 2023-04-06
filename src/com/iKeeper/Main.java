package com.iKeeper;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Main {

    public static void main(String[] args)throws IOException {
        for(int i=0; i<4;i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
            int num1 = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int num2 = Integer.parseInt(br.readLine());
            calculato cal = new calculato(num1, num2, str);
            cal.prin();
        }
    }
}

