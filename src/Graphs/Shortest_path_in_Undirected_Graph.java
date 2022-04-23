package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Shortest_path_in_Undirected_Graph {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>() ;

    public Shortest_path_in_Undirected_Graph(int m) {
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>()) ;
        }
    }

    public static ArrayList<ArrayList<Integer>> adjacencyList(Scanner sc,int n, int m){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>() ;
        int u,v ;
        for (int i = 0; i < m; i++) {
            u=sc.nextInt() ;
            v=sc.nextInt() ;

            adj.get(u).add(v) ;
            adj.get(v).add(u) ;
        }
        return adj ;
    }

    public void shortestPath(ArrayList<ArrayList<Integer>> adj, int source, int vertices){
        int[] distance=new int[vertices] ;

        for (int i = 0; i < vertices; i++) {
            distance[i]=Integer.MAX_VALUE ;
        }

        Queue<Integer> queue=new LinkedList<>() ;
        distance[source]=0 ;
        queue.add(source) ;
        while(!queue.isEmpty()){
            int node=queue.poll() ;
            for (int ele:
                 adj.get(node)) {
                if(distance[node]+1<distance[ele]){
                    distance[ele]=distance[node]+1;
                    queue.add(ele) ;
                }
            }
            for (int i = 0; i < vertices; i++) {
                System.out.print(distance[i]+" ");
            }
        }
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>() ;
            int n= sc.nextInt();
            int m=sc.nextInt() ;
            Shortest_path_in_Undirected_Graph obj=new Shortest_path_in_Undirected_Graph(m) ;
            adj=obj.adjacencyList(sc,n,m) ;
            obj.shortestPath(adj,0,n) ;
        }
    }
}
