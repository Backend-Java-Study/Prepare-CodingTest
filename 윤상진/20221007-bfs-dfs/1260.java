import java.util.*;
import java.io.*;

public class Main{
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  public static boolean[] visited;
  
  public static void dfs(int v){
    visited[v] = true;

    System.out.print(v + " ");

    for(int i =0; i<graph.get(v).size(); i++){
      int y = graph.get(v).get(i);
      if(!visited[y]) dfs(y);
    }
  }

  public static void bfs(int v){
    Queue<Integer> queue = new LinkedList<>();
    
    queue.offer(v);
    visited[v] = true;

    while(!queue.isEmpty()){
      int x = queue.poll();

      System.out.print(x + " ");
      for(int i=0 ; i <graph.get(x).size() ; i++){
        int y = graph.get(x).get(i);
        if(!visited[y]){
          queue.offer(y);
          visited[y] = true;
        }
      }
    }
    
  }
  
  public static void main(String args[]){
    
    Scanner scanner = new Scanner(System.in);
    
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int v = scanner.nextInt();

    for(int i=0; i<n+1; i++){
      graph.add(new ArrayList<Integer>());
    }

    for(int i=0; i<m ; i++){
      int num1 = scanner.nextInt();
      int num2 = scanner.nextInt();
      graph.get(num1).add(num2);
      graph.get(num2).add(num1);
    }

    for(int i=0; i<n+1; i++){
       Collections.sort(graph.get(i));
    }

    visited = new boolean[n+1];
    dfs(v);
    System.out.println();
    visited = new boolean[n+1];
    bfs(v); 
  }
}
