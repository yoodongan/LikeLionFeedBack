// 문제 : 아래가 실행되도록 해주세요.

class Project {
    public static void main(String[] args) {
        전사 a전사 = new 홍길동();
        a전사.a무기 = new 활();

        a전사.공격();
        // 출력 => 홍길동이(가) 활(으)로 공격합니다.

        a전사 = new 홍길순();

        a전사.공격();
        // 출력 => 홍길순이(가) 칼(으)로 공격합니다.

        a전사.a무기 = new 창();
        a전사.공격();
        // 출력 => 홍길순이(가) 창(으)로 공격합니다.
    }
}
abstract class 전사 {
    String 이름;
    무기 a무기;
    void 공격() {
        a무기.작동(이름);
    }
}
class 홍길동 extends 전사 {
    홍길동(){
        this.이름  ="홍길동";
    }

}
class 홍길순 extends 전사 {
    홍길순(){
        this.이름  ="홍길순";
        a무기 = new 칼();
    }

}
abstract class 무기{
    String 무기이름;
    void 작동(String name){
        System.out.println(name + "이 "+무기이름+"공격함");
    }
}
class 활 extends 무기{
    활() {
        무기이름 = "활";
    }
}
class 창 extends 무기{
    창() {
        무기이름 = "창";
    }
}
class 칼 extends 무기{
    칼() {
        무기이름="칼";
    }
}