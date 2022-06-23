package likelion;

public class Main {
    public static void sum1(int a, int b) {
        System.out.println(a + b);
    }

    public static int sum2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        sum1(a, b);
        int c = sum2(a, b);
        System.out.println(c);
    }
}
