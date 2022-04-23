package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>() ;
    public DFS(int m){

        for (int i = 0; i <= m; i++) {
            adj.add(new ArrayList<>()) ;
        }
    }

    public void makeGraph(Scanner sc,int m){
        int u,v ;
        for (int i = 0; i < m; i++) {
            u=sc.nextInt() ;
            v=sc.nextInt() ;
            adj.get(u).add(v) ;
            adj.get(v).add(u) ;
        }
    }

    public void DFS_Fun(int index,boolean[] visited){
        System.out.print(index+"->");
        visited[index]=true ;
        for (Integer node:
             adj.get(index)) {
            if(!visited[node])
                DFS_Fun(node,visited);
        }
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt() ;
            int m=sc.nextInt() ;
            DFS obj=new DFS(m) ;
            obj.makeGraph(sc,n);
            boolean[] visited=new boolean[n+1] ;
            for (int i = 1; i <=n ; i++) {
                if(!visited[i]){
                    obj.DFS_Fun(i,visited);
                }
            }
        }
    }
}

//Example Input
//            1-----2
//            | \    | \
//            |   \  |  4
//            |     \|  /
//            5 ---- 3

//            m=7, n=5

//5 7
//1 2
//1 3
//1 5
//2 3
//2 4
//3 4
//5 3
