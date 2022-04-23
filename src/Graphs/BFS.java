package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static ArrayList<Integer> BFS(int v, ArrayList<ArrayList<Integer>> adj){
        //Make an ans arraylist
        ArrayList<Integer> bfsAns=new ArrayList<>() ;
        //Make a visited array with size v+1, since we are traversing from 1
        boolean[] vis=new boolean[v+1] ;
        //Now, check for each node the following conditions:-
        // 1. Is it visited before, if yes move to next node else add it in queue and set visited=true
        // 2. Now check for adjacent elements of the following node, if it is visited return else check for another node
        // and set to visited=true and it to queue
        // Repeat until the queue is empty and all vertices are visited
        for (int i = 1; i <v ; i++) {
            if(!vis[i]){
                Queue<Integer> queue=new LinkedList<>() ;
                queue.add(i) ;
                vis[i]=true ;
                while(!queue.isEmpty()){
                    Integer node=queue.poll();
                    bfsAns.add(node) ;
                    for (Integer ele:
                         adj.get(node)) {
                        if(!vis[ele]){
                            vis[ele]=true ;
                            queue.add(ele) ;
                        }
                    }
                }
            }

        }
        return bfsAns ;
    }

    public static ArrayList<ArrayList<Integer>> adjacencyList(Scanner sc,int n, int m){
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
        return adj ;
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>() ;
            System.out.println("Enter Adjacency list ");
            adj=adjacencyList(sc,sc.nextInt(),sc.nextInt()) ;
            System.out.println("Enter number of vertices ");
            int v= sc.nextInt();
            System.out.println("BFS for entered graph be ");
            System.out.println(BFS(v,adj));
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