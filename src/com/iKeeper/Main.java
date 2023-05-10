package com.iKeeper;
import java.util.*;

/*
기능 정의
입력 함수 제작 <- 1000 단위로 반복
arraylist로(입력한 로또번호) 저장
arraylist로 arraylist를(입력한 로또번호) 저장

0 ~ 99 의 숫자를 리턴하는 함수 <- 6번 반복 6번째는 보너스 번호

arraylist를 이용해 당첨 번호 저장

if를 통해 각각 비교 후 결과 표시

 */
public class Main {
    public static void main(String[] args) {


    }
    public class Lotto{
        ArrayList<Integer> userNum = new ArrayList<Integer>(); //사용자가 입력한 번호 (6개 입력되면 저장하고 비우고 다시 입력)
        ArrayList<Integer> winNum = new ArrayList<Integer>(); // 당첨 번호
        ArrayList<ArrayList<Integer>> arrayUserLo= new ArrayList<ArrayList<Integer>>(); // 사용자의 로또번호들을 저장
        Scanner scan = new Scanner(System.in);



        void setArrayUserLo(ArrayList<Integer> e){
            arrayUserLo.add(e);
        }
        void input(){// 입력 받은 후 전달, 입력받은 값 비우기
            for(int i = 0; i < 6; i++){
                userNum.add(scan.nextInt());
            }
            setArrayUserLo(userNum);
            userNum.clear(); //비우기
        }
        void random(){ // 랜덤 값 저장
            for(int i = 0; i < 6; i++){
                winNum.add((int)(Math.random()*99));
            }
        }

        void run(){
            System.out.println("원이 입력되었습니다.");
            System.out.println("장을 구매합니다.");
            System.out.println("오늘 담첨번호는 ");

            if() //같은 만큼 당첨금 출력
        }
    }

}

