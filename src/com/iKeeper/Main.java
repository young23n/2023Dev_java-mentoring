package com.iKeeper;
import java.util.*;

/*
기능 정의
입력 함수 제작 <- 1000 단위로 반복
arraylist로(입력한 로또번호) 저장
arraylist로 arraylist를(입력한 로또번호) 저장
0 ~ 99 의 숫자를 리턴하는 함수 <- 7번 반복 7번째는 보너스 번호
arraylist를 이용해 당첨 번호 저장
if를 통해 각각 비교 후 결과 표시
중복방지 구현
 */
public class Main {
    public static void main(String[] args) {
        Lotto lo = new Lotto();
        lo.run();

    }

    public static class Lotto {
        ArrayList<Integer>[] userNum; //사용자가 입력한 번호
        ArrayList<Integer> winNum = new ArrayList<>(); // 당첨 번호
        int money;
        int checkCount = 0;
        int checkBCount = 0;
        Scanner scan = new Scanner(System.in);

        void input(int money) {// 입력 받은 값 저장
            userNum = new ArrayList[money/1000];
            for (int i = 0; i < money / 1000; i++) {
                userNum[i] = new ArrayList<Integer>();
                System.out.println("6자리 번호를 입력하세요");
                for (int k = 0; k < 6; k++) {
                    userNum[i].add(scan.nextInt());
                }
            }
        }

        void random() { // 랜덤 값 저장(당첨번호) + 중복방지
            for (int i = 0; i < 7; i++) {//일단 다집어 넣음
                winNum.add((int) (Math.random() * 99));
            }
            for (int i = 0; i < 7; i++) {
                 for(int k = 0; k < 7; k++){// 한개씩 비교 같은 인덱스는 제외
                     if(winNum.get(i) == winNum.get(k) && i != k){
                         winNum.set(i,(int) (Math.random() * 99));//다른 값으로 바꾸기
                         k = 0;// 바뀐 값이 또 중복될 수 있기에 다시 탐색
                     }
                 }
            }
        }


        void checkNum(int money){//정답인 번호는 해당 리스트에서 지우기
            for(int i = 0; i < money / 1000; i++){
                for(int j = 0; j  < 6; j++){//당첨 체크
                    if(userNum[i].get(j) == winNum.get(j)){
                        checkCount++;
                        userNum[i].remove(j);
                    }
                }
            }
            for(int i = 0; i < money / 1000; i++){// 지워지고 남은 값들 보너스번호 탐색
                for(int k = 0; k < 6; k++){
                    if(userNum[i].contains(winNum.get(6))){
                        checkBCount++;
                    }
                }
            }
        }


        void run() {
            System.out.println("돈을 입력하세요 1000원 단위로만 받습니다.");
            money = scan.nextInt();
            System.out.println(money + "원이 입력됐습니다.");
            System.out.println(money / 1000 + "장을 구매합니다.");

            input(money);
            System.out.println("입력된 값: ");

            for (ArrayList ar : userNum) {//장 마다 입력된 값들 출력
                System.out.print(ar + " ");
                System.out.println();
            }
            System.out.println();

            random();
            System.out.println("오늘 담첨번호는 ");

            int cn = 0;// "보너스 번호:" 출력용
            for(Integer ar : winNum){
                cn++;
                if(cn == 7){//7번째 인덱스는 보너스 번호
                    System.out.print("보너스 번호: ");
                }
                System.out.print(ar + " ");
            }
            System.out.println();

            checkNum(money);
            if(checkCount == 4 && checkBCount == 0){
                System.out.println("4등입니다. 당첨금:100000");

            } else if (checkCount == 5 && checkBCount == 0) {
                System.out.println("3등입니다. 당첨금:1000000");
            } else if (checkCount == 5 && checkBCount == 1) {
                System.out.println("2등입니다. 당첨금:10000000");
            } else if (checkCount == 6 && checkBCount == 0) {
                System.out.println("1등입니다. 당첨금:100000000");
            } else {
                System.out.println("꽝입니다.");
            }
        }
    }
}