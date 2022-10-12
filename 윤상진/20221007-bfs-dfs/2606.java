import java.util.*;
import java.io.*;

public class Main{
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  public static boolean[] visited;


  public static int bfs(int v){
    Queue<Integer> queue = new LinkedList<>();
    int result = 0;
    queue.offer(v);
    visited[v] = true;

    while(!queue.isEmpty()){
      int x = queue.poll();
      result++;
      for(int i=0 ; i <graph.get(x).size() ; i++){
        int y = graph.get(x).get(i);
        if(!visited[y]){
          queue.offer(y);
          visited[y] = true;
        }
      }
    }
    return result;
  }
  
  public static void main(String args[]){
    
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    for(int i=0; i<n+1; i++){
      graph.add(new ArrayList<Integer>());
    }

    for(int i=0; i<m; i++){
      int num1 = scanner.nextInt();
      int num2 = scanner.nextInt();

      graph.get(num1).add(num2);
      graph.get(num2).add(num1);
    }

    visited = new boolean[n+1];
    System.out.println(bfs(1)-1);
  }
}
