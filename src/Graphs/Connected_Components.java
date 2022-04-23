package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Connected_Components {

    int n ; //number of vertices
    ArrayList<ArrayList<Integer>> adj ;
    // Make a constructor and initialise the list items as zero
    public Connected_Components(int n){
        this.n=n ;
        adj=new ArrayList<>() ;
        for (int i = 0; i < n; i++) {
            adj.add(i,new ArrayList<>()) ;
        }
    }

    public  void addEdge(int u, int v){
        adj.get(u).add(v) ;
        adj.get(v).add(u) ;
    }

    public void DFS_Util(int v, boolean[] vis){
        vis[v]=true ;
        System.out.print(v+" ");
        for (int x: adj.get(v)
             ) {
            if(!vis[x]){
                DFS_Util(v,vis);
            }
        }
    }

    void connectedComponents(){
        boolean[] visited=new boolean[n] ;
        for (int v = 0; v < n; v++) {
            if(!visited[v]){
                DFS_Util(v,visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Connected_Components graph=new Connected_Components(5) ;
        graph.addEdge(1,0);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        System.out.println(
                "Following are connected components");
        graph.connectedComponents();
    }
}
