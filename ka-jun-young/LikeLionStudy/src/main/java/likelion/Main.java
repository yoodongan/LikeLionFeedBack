package likelion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public static int calc(String s) {
        String[] sSplit = s.split(" ");
        int rs = 0;
        for (int i = 0; i < sSplit.length; i += 2) {
            rs = Integer.parseInt(sSplit[i]);
        }
        return rs;
    }
}
