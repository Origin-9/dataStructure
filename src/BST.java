import java.util.Stack;
import java.util.TreeMap;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

//    //向BST中添加节点
//    public void add(E e){
//        if(root == null) {
//            root = new Node(e);
//            size++;
//        }
//        else
//            add(root, e);
//    }
//
//    //向根节点 node 添加新节点。
//    public void add(Node node, E e){
//        if(e.equals(node.e)){
//            return;
//        }
//        else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e) < 0)
//            add(node.left, e);
//        else
//            add(node.right,e);
//    }

    public void add(E e){
        add(root, e);
    }

    //以 node 为根节点的二分搜索树，插入元素 e
    //返回插入新元素后二分搜索树的根
    public Node add(Node node, E e){
        if(node == null)
            return new Node(e);

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }
        else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    //前序遍历的非递归
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node cur = stack.pop();
            System.out.println(cur);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    //中序遍历的非递归实现
    public void inOrderNr(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
    }

}
