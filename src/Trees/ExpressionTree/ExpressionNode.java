package Trees.ExpressionTree;

public class ExpressionNode {
    String val;
    ExpressionNode left;
    ExpressionNode right;

    public ExpressionNode(String val){
        if (val != null) this.val = val;
        this.left = null;
        this.right = null;
    }

    public ExpressionNode(String val, ExpressionNode left, ExpressionNode right){
        if (val != null) this.val = val;
        this.left= left;
        this.right = right;
    }

}
