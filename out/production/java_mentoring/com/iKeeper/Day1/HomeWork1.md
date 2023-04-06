캐릭터 배열 2개

캐릭터 클래스 {
    체력 Math.random범위 지정
    공격력 Math.random범위 지정
    get 체력(){리턴}
    get 공격력(){리턴}
}

클래스 game{

    입력받기 기능

    int tempAttack 10~50의 변동적인 공격력 합산을 임시로 저장
    boolean check 커맨드로 다시시작과 완전 종료 판단
    
    hit 기능
    tempAttack을 가져와서 체력에 적용

    boolean 커맨드 기능
        if 1(다시시작) 2(종료) 
        return boolean check false;

    순서 기능
    누가 선공인지 math.random 1~2 리턴
    
    승리한 플레이어 출력 기능
    if 

    처음 플레이어 스텟 공개 기능
    
        
}

try - catch로 예외 발생 알리고 종료