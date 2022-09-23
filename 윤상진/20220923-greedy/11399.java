import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    int result = 0;

    for(int i=0; i<n; i++){
      arr[i] = scanner.nextInt();
    }

    Arrays.sort(arr);

    for(int i=1; i<n; i++){
      arr[i] = arr[i-1] + arr[i];
    }

    for(int i=0; i<n; i++){
      result += arr[i];
    }

    System.out.println(result);
  }
}
