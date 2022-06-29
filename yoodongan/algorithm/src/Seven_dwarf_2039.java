import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Seven_dwarf_2039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        int fakeDwarf1 = 0;
        int fakeDwarf2 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    fakeDwarf1 = arr[i];
                    fakeDwarf2 = arr[j];
                    Arrays.sort(arr);
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == fakeDwarf1 || arr[i] == fakeDwarf2) continue;
            System.out.println(arr[i]);
        }
    }
}
