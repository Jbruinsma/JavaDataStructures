package Trees.BinarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public BinarySearchTree(){
        this.root = null;
    }

    public BinarySearchTree(T val){
        if (val != null) {
            this.root = new TreeNode<T>(val);
        }
    }

    public BinarySearchTree(T[] array){
        if (array.length > 0){
            this.root = new TreeNode<>(array[0]);
            for (int i = 1; i < array.length; i ++){
                if (array[i] != null) {
                    this.insert(array[i]);
                }
            }
        }
    }

    @Override
    public String toString(){
        return this.toTuple(this.root);
    }

    public void insert(T val){
        if (val != null) {
            this.root.insert(val);
        }
    }

    public void insert(T[] array){
        for (int i = 1; i < array.length; i ++) {
            if (array[i] != null) {
                this.root.insert(array[i]);
            }
        }
    }

    public void delete(T val){
        this.root = this.root.delete(val);
    }

    public boolean contains(T val){
        return this.root.contains(val);
    }

    public TreeNode<T> find(T val){
        return this.root.find(val);
    }

    public ArrayList<T> preOrderTraversal(){
        return this.root.preOrder();
    }

    public ArrayList<T> inOrderTraversal(){
        return this.root.inOrder();
    }

    public ArrayList<T> postOrderTraversal(){
        return this.root.postOrder();
    }

    public ArrayList<T> levelOrderTraversal(){
        return this.root.levelOrder();
    }

    public T findMin(){
        return this.root.findMin();
    }

    public T findMax(){
        return this.root.findMax();
    }

    public int height(){
        return this.root.height();
    }

    public int size(){
        return this.root.size();
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    private String toTuple(TreeNode<T> node){
        if (node == null) return null;
        else return "(" + node.val + ", " + this.toTuple(node.left) + ", " + this.toTuple(node.right) + ")";
    }
        
    public static void main(String[] args){
        Integer[] vals = {6, 5, 3, 4, 2, 1, 7, 9, 8, 10};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(vals);
        System.out.println("Binary Search Tree: \n");
        System.out.println(bst + "\n");
        System.out.println("Pre Order Traversal: \n");
        System.out.println(bst.preOrderTraversal() + "\n");
        System.out.println("In Order Traversal: \n");
        System.out.println(bst.inOrderTraversal() + "\n");
        System.out.println("Post Order Traversal: \n");
        System.out.println(bst.postOrderTraversal() + "\n");
        System.out.println("Level Order Traversal: \n");
        System.out.println(bst.levelOrderTraversal() + "\n");
        System.out.println("Height:\n");
        System.out.println(bst.height() + "\n");
        System.out.println("Size: \n");
        System.out.println(bst.size() + "\n");
    }

}
