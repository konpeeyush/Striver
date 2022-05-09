package Graphs;

import java.util.* ;
class Node{
    int u ;
    int v ;
    int w ;
    public Node(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
class Sort implements Comparator<Node>{
    @Override
    public int compare(Node n1,Node n2){
        return n1.w- n2.w;
    }
}

class Disjoint {
    int[] parent;
    int[] rank;

    Disjoint(int n) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;

        }
        System.out.println("This is the Parent array");
        System.out.println(Arrays.toString(parent));
        rank=new int[n];


    }


    public int findParent(int index){
        if (parent[index] == index) {
            return index;
        }
        parent[index] = findParent(parent[index]);
        return parent[index];
    }

    public void union(int u, int v){
        u= findParent(u);
        v= findParent(v);
        if (rank[u]>rank[v]){

            parent[v]=u;


        }
        else if (rank[u]<rank[v]){
            parent[u]=v;
        }
        else{
            parent[v]=u;

            rank[u]++;
        }
    }
}


public class Kruskal_Algorithm {

    public static void Kruskal(ArrayList<Node> adj){
        Collections.sort(adj,new Sort()) ;
        Disjoint set = new Disjoint(6);

        int totalCost=0;
        ArrayList<Node> mst= new ArrayList<>();

        for (Node t : adj) {

            if(set.findParent(t.u)!=set.findParent(t.v)){
                mst.add(t);
                set.union(t.u, t.v);
                totalCost+=t.w;
            }

        }
        System.out.println("Total Cost of the mst formed out the the given Graph is " +totalCost);


    }

    public static void main(String[] args) {
        ArrayList<Node>ad= new ArrayList<>() ;
        ad.add(new Node(0 , 1, 2));
        ad.add(new Node(0 , 3, 6));
        ad.add(new Node(1 , 3, 8));
        ad.add(new Node(1 , 2, 3));
        ad.add(new Node(1 , 4, 5));
        ad.add(new Node(2 , 4, 7));

        Kruskal(ad);
    }
}
