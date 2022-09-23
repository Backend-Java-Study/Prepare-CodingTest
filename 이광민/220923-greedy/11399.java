import java.util.Arrays;
import java.util.Scanner;

public class Backjoon11399 {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int [] time = new int[n];
    for (int i = 0; i < n; i++){
        time[i] = sc.nextInt();
    }
    Arrays.sort(time);
    int sum = 0;
    for (int i = 0; i < n; i++){
      for (int j = 0; j<n-i; j++){
        sum += time[j];
      }
    }
    System.out.println(sum);
}
