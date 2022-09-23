import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    String str = scanner.next();
    String[] nums = str.split("\\-");
  
    // System.out.println(Arrays.toString(nums));

    for(int i=0; i<nums.length; i++){
      String[] numsPlus = nums[i].split("\\+");
      int sum = 0;
      
      for(int j=0; j<numsPlus.length; j++){
        sum += Integer.parseInt(numsPlus[j]);
      }
      nums[i] = String.valueOf(sum);
    }

    int result = Integer.parseInt(nums[0]);
    for(int i=1; i<nums.length; i++){
      result -= Integer.parseInt(nums[i]);
    }

    System.out.println(result);
  }
}
