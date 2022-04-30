package Graphs;

import java.util.*;

class pair implements Comparator<pair>{
    int vertex ;
    int weight ;
    pair(int vertex, int weight){
        this.vertex=vertex ;
        this.weight=weight ;
    }

    public pair() {

    }

    @Override
    public int compare(pair node1, pair node2) {
        if(node1.weight> node2.weight){
            return 1;
        }
        else if(node2.weight> node1.weight){
            return -1 ;
        }
        return 0 ;
    }
}

class makeGraph{
    ArrayList<ArrayList<pair>> adj=new ArrayList<>() ;
    int n ;

    public makeGraph() {
        try(Scanner sc=new Scanner(System.in)){
            System.out.println("Enter number of vertex ");
            n=sc.nextInt();
            System.out.println("Enter number of edges ");
            int m=sc.nextInt() ;
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<pair>());
            }
            int u, v, w ;
            System.out.println("Enter edges along with weight ");
            for (int i = 0; i < m; i++) {
                u=sc.nextInt() ;
                v=sc.nextInt() ;
                w=sc.nextInt() ;
                adj.get(u).add(new pair(v,w)) ;
                adj.get(v).add(new pair(u,w)) ;
            }
        }
    }
}
public class Dijkstas_Algorithm {

    public static void Dijkstra(ArrayList<ArrayList<pair>> adj, int[] cost, int source){
        cost[source]=0 ;
        PriorityQueue<pair> queue=new PriorityQueue<>(cost.length,new pair()) ;
        queue.add(new pair(source,0)) ;
        while(queue.size()!=0){
            pair node=queue.poll() ;
            for (pair ele:
                    adj.get(node.vertex)) {
                int newCost=node.weight+ele.weight;
                if(newCost<cost[ele.vertex]){
                    cost[ele.vertex]=newCost ;
                    queue.add(new pair(ele.vertex,newCost)) ;
                }
            }
        }
    }
    public static void main(String[] args) {
        makeGraph obj=new makeGraph() ;
        int[] cost=new int[obj.n] ;
        for (int i = 0; i < cost.length; i++) {
            cost[i]=Integer.MAX_VALUE ;
        }
        Dijkstra(obj.adj,cost,0);
        System.out.println("Cost "+ Arrays.toString(cost));
    }
}
// 0 1 2 1 2 4 1 4 5 2 4 1 3 2 3 0 3 1
//0 1 2
//1 2 4
//1 4 5
//2 4 1
//3 2 3
//0 3 1
