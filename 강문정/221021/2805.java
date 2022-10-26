import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        Arrays.sort(array);

        long left = 0;
        long right = array[n - 1];

        while (left <= right) {
            long middle = (right + left) / 2;
            long sum = 0;
            for (long tree : array) {
                if (tree > middle)
                    sum += (tree - middle);
            }
            if (sum >= m) {
                left = middle + 1;
            } else
                right = middle - 1;
        }

        System.out.println(right);
    }
}
