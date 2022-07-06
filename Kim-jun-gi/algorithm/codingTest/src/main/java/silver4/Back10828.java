package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스택
public class Back10828 {
    public static int[] stack;
    public static int size = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        stack = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stackPush(num);
                    break;
                case "pop":
                    System.out.println(stackPop());
                    break;
                case "size":
                    System.out.println(stackSize());
                    break;
                case "empty":
                    System.out.println(stackEmpth());
                    break;
                case "top":
                    System.out.println(stackTop());
                    break;
                default:
                    System.out.println("잘못된 값입니다");
            }
        }
    }
    public static void stackPush(int num) {
        stack[size]=num;
        size++;
    }

    public static int stackPop() {
        if(stackEmpth()==1){
            return -1;
        }
        size--;
        return stack[size];
    }
    public static int stackSize() {
        return size;
    }
    public static int stackEmpth() {
        if(size==0){
            return 1;
        }
        return 0;
    }
    public static int stackTop() {
        if(stackEmpth()==1){
            return -1;
        }
        return stack[size-1];
    }

}

