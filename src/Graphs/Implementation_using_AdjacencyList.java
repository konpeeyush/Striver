package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Implementation_using_AdjacencyList {
    public static void adjacencyList(Scanner sc,int n, int m){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>() ;
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>()) ;
        }
        int u,v ;
        for (int i = 0; i < m; i++) {
            u=sc.nextInt() ;
            v=sc.nextInt() ;

            adj.get(u).add(v) ;
            adj.get(v).add(u) ;
        }
        System.out.println(adj);
    }

    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            adjacencyList(sc,sc.nextInt(), sc.nextInt());

            //Example Input
//            1-----2
//            | \    | \
//            |   \  |  4
//            |     \|  /
//            5 ---- 3

//            m=7, n=5

//            AdjacencyList for above input be:-
//        [[], [2, 3, 5], [1, 3, 4], [1, 2, 5, 4], [2, 3], [1, 3], []]
        }
    }
}
