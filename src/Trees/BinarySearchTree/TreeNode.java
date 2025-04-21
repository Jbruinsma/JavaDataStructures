package Trees.BinarySearchTree;

import java.util.ArrayList;

public class TreeNode<T extends Comparable<T>>{
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T val){
        if (val != null) this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString(){
        return this.val.toString();
    }

    public void insert(T val){
        if (val != null){
            int comparison = this.val.compareTo(val);
            if (comparison == 0) return;
            if (comparison > 0){
                if (this.left == null) this.left = new TreeNode<T>(val);
                else this.left.insert(val);
            } else {
                if (this.right == null) this.right = new TreeNode<T>(val);
                else this.right.insert(val);
            }
        }
    }

    public TreeNode<T> delete(T val){
        if (val == null) return this;
        int comparison = this.val.compareTo(val);
        if (comparison > 0) {
            if (this.left != null) this.left = this.left.delete(val);
        } else if (comparison < 0){
            if (this.right != null) this.right = this.right.delete(val);
        } else {
            if (this.left == null && this.right == null) return null;
            if (this.left == null) return this.right;
            if (this.right == null) return this.left;
            this.val = this.right.findMin();
            this.right.delete(this.val);
        }
        return this;
    }

    public boolean contains(T val){
        if (val == null) return false;
        int comparison = this.val.compareTo(val);
        if (val.equals(this.val)) return true;
        else if (comparison > 0 && this.left != null) return this.left.contains(val);
        else if (comparison < 0 && this.right != null) return this.right.contains(val);
        return false;
    }

    public TreeNode<T> find(T val){
        if (val == null) return null;
        int comparison = this.val.compareTo(val);
        if (val.equals(this.val)) return this;
        else if (comparison > 0 && this.left != null) return this.left.find(val);
        else if (comparison < 0 && this.right != null) return this.right.find(val);
        return null;
    }

    public ArrayList<T> preOrder(){
        ArrayList<T> vals = new ArrayList<>();
        vals.add(this.val);
        if (this.left != null) vals.addAll(this.left.preOrder());
        if (this.right != null) vals.addAll(this.right.preOrder());
        return vals;
    }

    public ArrayList<T> inOrder(){
        ArrayList<T> vals = new ArrayList<>();
        if (this.left != null) vals.addAll(this.left.inOrder());
        vals.add(this.val);
        if (this.right != null) vals.addAll(this.right.inOrder());
        return vals;
    }

    public ArrayList<T> postOrder(){
        ArrayList<T> vals = new ArrayList<>();
        if (this.left != null) vals.addAll(this.left.postOrder());
        if (this.right != null) vals.addAll(this.right.postOrder());
        vals.add(this.val);
        return vals;
    }

    public ArrayList<T> levelOrder(){
        ArrayList<T> vals = new ArrayList<>();
        ArrayList<TreeNode<T>> queue = new ArrayList<>();
        queue.add(this);
        while (!queue.isEmpty()){
            TreeNode<T> currNode = queue.removeFirst();
            vals.add(currNode.val);
            if (currNode.left != null) queue.add(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
        }
        return vals;
    }

    public T findMin(){
        if (this.left == null) return this.val;
        else return this.left.findMin();
    }

    public T findMax(){
        if (this.right == null) return this.val;
        else return this.right.findMax();
    }

    public int height(){
        int leftHeight = -1;
        int rightHeight = -1;
        if (this.left != null) leftHeight = this.left.height();
        if (this.right != null) rightHeight = this.right.height();
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int size(){
        int leftSize = 0;
        int rightSize = 0;
        if (this.left != null) leftSize = this.left.size();
        if (this.right != null) rightSize = this.right.size();
        return 1 + leftSize + rightSize;
    }

}
