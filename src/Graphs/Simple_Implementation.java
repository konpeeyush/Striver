package Graphs;

import java.util.Arrays;
import java.util.Scanner;

//This is an implementation using adjacency matrix
public class Simple_Implementation {

    public static void adjacencyMatrix(Scanner sc,int n,int m){
        int[][] adj=new int[n+1][n+1] ;
        int u,v ;

        for (int i = 0; i < m; i++) {
            u=sc.nextInt() ;
            v=sc.nextInt() ;
            adj[u][v]=1 ;
            adj[v][u]=1 ;
        }
        for (int i = 0; i < adj.length; i++) {
            System.out.println(Arrays.toString(adj[i]));
        }
    }
    public static void main(String[] args) {
//        int n=3 ;
//        int m=3 ;
//
//        //Create an adjacency matrix with size N+1
//        int[][] adj=new int[n+1][n+1] ;
//
////        adj[u][v]=1 ;
////        adj[v][u]=1 ;
//
//        //edge-1
//        adj[1][2]=1 ;
//        adj[2][1]=1 ;
//        //Since it is an undirected graph
//
//        //edge-2
//        adj[2][3]=1 ;
//        adj[3][2]=1;
//
//        //edge-3
//        adj[1][3]=1 ;
//        adj[3][1]=1 ;
        
        try(Scanner sc=new Scanner(System.in)){
            adjacencyMatrix(sc,sc.nextInt(),sc.nextInt());
            //Example Input
//            1-----2
//            | \    | \
//            |   \  |  4
//            |     \|  /
//            5 ---- 3

//            m=7, n=5
//
//            Adjacency matrix for above example be:-
//                    [0, 0, 0, 0, 0, 0]
//                    [0, 0, 1, 1, 0, 1]
//                    [0, 1, 0, 1, 1, 0]
//                    [0, 1, 1, 0, 1, 1]
//                    [0, 0, 1, 1, 0, 0]
//                    [0, 1, 0, 1, 0, 0]

        }
    }
}
