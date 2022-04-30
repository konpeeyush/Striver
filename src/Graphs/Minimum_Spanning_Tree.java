package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparator<Pair>{
    private int vertex ;
    private int weight ;

    public Pair(int vertex, int weight) {
        this.vertex=vertex ;
        this.weight=weight ;
    }

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
        if(o1.weight<o2.weight)
            return 1 ;
        else if(o1.weight>o2.weight)
            return -1 ;
        return 0;
    }

    public Pair() {
    }
}

class makeGraph2{
    ArrayList<ArrayList<Pair>> adj=new ArrayList<>() ;
    int n ;

    public makeGraph2() {
        try(Scanner sc=new Scanner(System.in)){
            System.out.println("Enter number of vertex ");
            n=sc.nextInt();
            System.out.println("Enter number of edges ");
            int m=sc.nextInt() ;
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            int u, v, w ;
            System.out.println("Enter edges along with weight ");
            for (int i = 0; i < m; i++) {
                u=sc.nextInt() ;
                v=sc.nextInt() ;
                w=sc.nextInt() ;
                adj.get(u).add(new Pair(v,w)) ;
                adj.get(v).add(new Pair(u,w)) ;
            }
        }
    }
}

public class Minimum_Spanning_Tree {
    ArrayList<ArrayList<Pair>> adj=new ArrayList<>() ;

    public static void Prims(ArrayList<ArrayList<Pair>> adj, int n){
        int[] key=new int[n] ;
        int[] parent=new int[n] ;
        boolean[] contains=new boolean[n] ;
        for (int i = 0; i < n; i++) {
            key[i]=Integer.MAX_VALUE ;
            parent[i]=-1;
            contains[i]=false;
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>(n,new Pair()) ;
        key[0]=0 ;
        queue.add(new Pair(0,key[0])) ;
        //MST contains n-1 edges, therefore loop will run n-1 times
        for (int i = 0; i < n-1; i++) {
            int neighbour=queue.poll().getVertex() ;
            contains[neighbour]=true ;
            for (Pair adjacentNeighbour:
                    adj.get(neighbour)) {
                if(!contains[adjacentNeighbour.getVertex()] && adjacentNeighbour.getWeight() < key[adjacentNeighbour.getVertex()]){
                    parent[adjacentNeighbour.getVertex()]=neighbour;
                    key[adjacentNeighbour.getVertex()]=adjacentNeighbour.getWeight() ;
                    queue.add(new Pair(adjacentNeighbour.getVertex(),key[adjacentNeighbour.getVertex()])) ;
                }
            }
        }
        for (int i = 1; i <n ; i++) {
            System.out.println(parent[i]+"-"+i);
        }
    }

    public static void main(String[] args) {
        makeGraph2 obj=new makeGraph2();
        Prims(obj.adj, obj.n);
    }
}

