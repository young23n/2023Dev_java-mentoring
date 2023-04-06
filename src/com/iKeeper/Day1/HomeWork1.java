package com.iKeeper.Day1;
import com.sun.source.tree.UsesTree;

import java.util.Scanner;
import java.util.Random;


public class HomeWork1 {
    public static void main(String[] args){
        Game game = new Game();
        game.run();

    }
}

class Character{
    String name;
    int health;
    int attack;
    int getHealth(){
        return health;
    }
    int getAttack(){
        return attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}

class Game{
    Character[] ch = new Character[2];
    boolean check = true; //다시시작 커맨드 구분
    Random random = new Random();
    int total; //총 공격력
    int randomDM; // 랜덤 가중치
    int chDM; //캐릭터 공격력
    int i = 0; //선공 출력 1번만 하게하는 변수

    void input(){// 입력 받기
        ch[0] = new Character();
        ch[1] = new Character();
        Scanner scan = new Scanner(System.in);

        System.out.println("캐릭터 1의 이름을 입력하세요.");
        ch[0].name = scan.nextLine();
        System.out.println("캐릭터 2의 이름을 입력하세요.");
        ch[1].name = scan.nextLine();

        ch[0].setHealth(random.nextInt(((300 - 100) + 1) + 100)); //최대값 최소값 반환 설정
        ch[1].setHealth(random.nextInt(((300 - 100) + 1) + 100));

        ch[0].setAttack(random.nextInt(((90 - 10) + 1) + 10));
        ch[1].setAttack(random.nextInt(((90 - 10) + 1) + 10));
    }

    int hit(int chNumber){//캐릭터의 대미지와 랜덤한 값을 더한 공격력 리턴
        randomDM = random.nextInt(((50 - 10) + 1) + 10);
        chDM = ch[chNumber].getAttack();
        return chDM + randomDM;
    }
    void fight() { //전투 계산,진행 밑 상황 출력

        for(;ch[0].getHealth() > 0 || ch[1].getHealth() > 0;){ //체력 0까지 반복
            if(first() == 0){
                for(;i == 0;i++){
                    System.out.println(ch[0].name + "님의 선공!");
                }
                total = hit(0);
                System.out.println(ch[0].name + "님의 공격 " + ch[1].getHealth() + " - " + total + " HIT!("+ chDM + " + " + randomDM +" 가중치!)");
                ch[1].setHealth(ch[1].getHealth() - total);
                System.out.println(ch[1].name + "님의 남은 체력: " + ch[1].getHealth());

                if(ch[1].getHealth() <= 0){
                    System.out.println(ch[0].name+"님의 승리!");
                    break;
                }//상대가 먼저 0되는지 확인

                total = hit(1);
                System.out.println(ch[1].name + "님의 공격 " + ch[0].getHealth() + " - " + total + " HIT!("+ chDM + " + " + randomDM +" 가중치!)");
                ch[0].setHealth(ch[0].getHealth() - total);
                System.out.println(ch[0].name + "님의 남은 체력: " + ch[0].getHealth());

                if(ch[0].getHealth() <= 0){
                    System.out.println(ch[1].name + "님의 승리!");
                    break;
                }
            }
            else{
                for(;i == 0;i++){
                    System.out.println(ch[1].name + "님의 선공!");}
                total = hit(1);
                System.out.println(ch[1].name + "님의 공격 " + ch[0].getHealth() + " - " + total + " HIT!("+ chDM + " + " + randomDM +" 가중치!)");
                ch[0].setHealth(ch[0].getHealth() - total);
                System.out.println(ch[0].name + "님의 남은 체력: " + ch[0].getHealth());

                if(ch[0].getHealth() <= 0){//상대가 먼저 0되는지 확인
                    System.out.println(ch[1].name + "님의 승리!");
                    break;
                }

                total = hit(0);
                System.out.println(ch[0].name + "님의 공격 " + ch[1].getHealth() + " - " + total + " HIT!("+ chDM + " + " + randomDM +" 가중치!)");
                ch[1].setHealth(ch[1].getHealth() - total);
                System.out.println(ch[1].name + "님의 남은 체력: " + ch[1].getHealth());

                if(ch[1].getHealth() <= 0){
                    System.out.println(ch[0].name + "님의 승리!");
                    break;
                }
            }
        }

    }
    int first(){
        return random.nextInt(2);// 0~1 반환(선공확인)
    }
    void showStatus(){
        System.out.println(ch[0].name + " " + ch[0].health + " " + ch[0].attack);
        System.out.println(ch[1].name + " " + ch[1].health + " " + ch[1].attack);
    }
    void run(){ // 전체실행
        while(check){//커맨드를 입력받아 check가 false로 변경시 종료
            input();
            showStatus();
            fight();
            int i = 0; //다시시작시 선공 체크 초기화


            try {
                System.out.println("다시 게임을 시작하시겠습니까? (1.다시시작, 2.종료)");
                Scanner scan = new Scanner(System.in);
                int command = scan.nextInt();
                if(command == 2) { check = false; }

            }
            catch(Exception e) {
                System.out.println("잘못된 값 입력 종료합니다.");
                break;
            }
        }
    }
}
