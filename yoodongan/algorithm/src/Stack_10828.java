import java.util.Scanner;

public class Stack_10828 {
    public static int[] stack;
    public static int size = 0;

    public static void push(int item){
        stack[size++] = item;
    }
    public static int pop(){
        if(size ==0){
            return -1;
        } else{
            int rest = stack[size-1];
            stack[size-1] = 0;
            size--;
            return rest;
        }
    }
    public static int size() {
        return size;
    }
    public static int empty(){
        if(size ==0){
            return 1;
        } else {
            return 0;
        }
    }
    public static int top() {
        if (size == 0) {
            return -1;
        }else {
            return stack[size-1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            switch(cmd) {
                case "push" :
                    push(sc.nextInt());
                    break;
                case "pop" :
                    sb.append(pop()).append("\n");
                    break;
                case "size" :
                    sb.append(size()).append("\n");
                    break;
                case "empty" :
                    sb.append(empty()).append("\n");
                    break;
                case "top" :
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}