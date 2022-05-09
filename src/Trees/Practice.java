package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice<T> {
    public  Practice<T> left ;
    public Practice<T> right ;
    public T data ;

    public Practice(T data) {
        this.data = data;
    }



    public static Practice<Integer> takeInputLevelWise(){
        int rootData ;
        try(Scanner sc=new Scanner(System.in)){
            Queue<Practice<Integer>> pendingNodes=new LinkedList<>() ;
            System.out.println("Enter root Data ");
            rootData=sc.nextInt() ;
            if(rootData==-1) return null ;
            Practice<Integer> root=new Practice<>(rootData) ;
            pendingNodes.add(root) ;
            while(!pendingNodes.isEmpty()){
                Practice<Integer> frontNode=pendingNodes.remove() ;
                System.out.println("Enter Left child of "+frontNode.data);
                int leftChild=sc.nextInt() ;
                if(leftChild!=-1){
                    Practice<Integer> child=new Practice<>(leftChild) ;
                    pendingNodes.add(child) ;
                    frontNode.left=child;
                }
                System.out.println("Enter Right child of "+frontNode.data);
                int rightChild=sc.nextInt() ;
                if(rightChild!=-1){
                    Practice<Integer> child=new Practice<>(rightChild) ;
                    pendingNodes.add(child) ;
                    frontNode.right=child;
                }
            }
            return root;
        }
    }

    public static void inorder(Practice<Integer> root){
        if(root==null) return;
        inorder(root.left) ;
        System.out.println(root.data+" ");
        inorder(root.right) ;
    }

    public static void print(Practice<Integer> root){
        Queue<Practice<Integer>> pendingNodes=new LinkedList<>() ;
        pendingNodes.add(root) ;
        while (!pendingNodes.isEmpty()){
            Practice<Integer> frontNode=pendingNodes.remove();
            System.out.print(frontNode.data+"");
            if(frontNode.left.data!=-1){

                System.out.print("L: "+frontNode.left.data+",");
                if(frontNode.left!=null) pendingNodes.add(frontNode.left) ;

            }
            if(frontNode.right.data!=-1){

                System.out.print("R: "+frontNode.right.data);
                if(frontNode.right!=null) pendingNodes.add(frontNode.right) ;

            }
            System.out.println();
        }
    }

    public static boolean isBST(Practice<Integer> root){
        if(root==null) return false ;

        int leftMax=maximum(root.left);
        int rightMin=minimum(root.right);

        if(leftMax>root.data) return false ;

        if(rightMin< root.data) return false;

        boolean isLeft=isBST(root.left) ;
        boolean isRight=isBST(root.right);

        if(isLeft && isRight) return true ;
        return false;
    }

    public static int maximum(Practice<Integer> root){
        if(root==null) return Integer.MIN_VALUE ;

        return Math.max(root.data, Math.max(maximum(root.left),maximum(root.right))) ;
    }

    public static int minimum(Practice<Integer> root){
        if(root==null) return Integer.MAX_VALUE ;

        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right))) ;
    }

    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            Practice<Integer> root=takeInputLevelWise() ;
//            inorder(root) ;
            print(root);
        }
    }
}
