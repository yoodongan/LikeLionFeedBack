// 문제 : 아래가 실행되도록 해주세요.
// 조건 : 매개변수를 사용하지 말아주세요.
class Project {
    public static void main(String[] args) {
        사람인력관리소 a사람인력관리소 = new 사람인력관리소();

        a사람인력관리소.add사람("홍길순", 33);
        // 나이가 33살인 1번째 사람(홍길순)이 추가되었습니다.
        a사람인력관리소.add사람("홍길동", 20);
        // 나이가 20살인 2번째 사람(홍길동)이 추가되었습니다.
        // 나이가 30살인 3번째 사람(임꺽정)이 추가되었습니다.
        a사람인력관리소.add사람("임꺽정", 30);
        a사람인력관리소.add사람("오호리", 11);
        a사람인력관리소.add사람("아라리", 23);

        사람 a사람1 = a사람인력관리소.get사람(1);
        a사람1.자기소개();
        // 저는 1번, 홍길순, 33살 입니다.

        사람 a사람2 = a사람인력관리소.get사람(2);
        a사람2.자기소개();
        // 저는 2번, 홍길동, 20살 입니다.

        사람 a사람3 = a사람인력관리소.get사람(3);
        a사람3.자기소개();
        // 저는 3번, 임꺽정, 30살 입니다.
        사람 a사람4 = a사람인력관리소.get사람(4);
        a사람4.자기소개();
        사람 a사람5 = a사람인력관리소.get사람(5);
        a사람5.자기소개();
    }
}

class 사람인력관리소 {
    int num=1;
    사람 사람1,사람2,사람3;
    void add사람(String name, int age) {
        if (사람1 == null){
            사람1 = new 사람(name,age,num);
        } else if (사람2 == null){
            사람2 = new 사람(name,age,num);
        } else if (사람3 == null){
            사람3 = new 사람(name,age,num);
        }

        if (num >=4){
            사람 결과 = 사람3;
            사람 사람n = new 사람(name,age,num);
            for (int i = 0; i < num-4; i++) {
                결과 = 결과.다음사람;
            }
            결과.다음사람 = 사람n;


        }
        System.out.printf("나이가 %d살인 %d번째 사람(%s)이 추가되었습니다.\n",age,this.num,name);
        this.num++;
    }
    사람 get사람(int number){
        if ( 사람1.number == number) {
            return 사람1;
        }
        if ( 사람2.number == number) {
            return 사람2;
        }
        if ( 사람3.number == number) {
            return 사람3;
        }
        사람 결과 = 사람3;
        for (int i = 0; i < number-3; i++) {
            결과 = 결과.다음사람;

        }
        return 결과;

    }


}
class 사람 {
    String name;
    int age;
    int number;
    사람 다음사람;
    public 사람(String name,int age,int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    void 자기소개() {
        System.out.printf("저는 %d번, %s, %d살 입니다.\n",number,name,age);
    }

}
