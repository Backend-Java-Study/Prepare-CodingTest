import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    for(int i=0; i<t; i++){
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n+1];

      for(int j=0; j<n; j++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr[a] = b;
      }

      int result = 1;
      int min_y = arr[1];
      for(int j=2; j<n+1; j++){
        if(arr[j] < min_y){
          min_y = arr[j];
          result++;
        }
      }

      System.out.println(result);
      
    }
  }
}
