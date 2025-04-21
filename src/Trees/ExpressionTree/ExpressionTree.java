package Trees.ExpressionTree;

import java.util.*;

public class ExpressionTree {
    ExpressionNode root;

    public ExpressionTree(){
        this.root = null;
    }

    public void buildFromPostfix(String postfixExpression){
        ArrayList<ExpressionNode> stack = new ArrayList<>();
        String[] tokens = postfixExpression.trim().split("\\s+");

        for (String item : tokens){
            if (item.matches("-?\\d+(\\.\\d+)?")){
                stack.add(new ExpressionNode(item));
            } else if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-")) {
                ExpressionNode right = stack.removeLast();
                ExpressionNode left = stack.removeLast();
                stack.add(new ExpressionNode(item, left, right));
            } else {
                throw new IllegalArgumentException("Invalid Operator: " + item);
            }
        }
        this.root = stack.removeLast();
    }

    public double evaluate(){
        return this.evaluate(this.root);
    }

    private double evaluate(ExpressionNode node){
            if (node.left == null && node.right == null) {
                return Double.parseDouble(node.val);
            }
            double left = this.evaluate(node.left);
            double right = this.evaluate(node.right);

            return switch (node.val) {
                case "*" -> left * right;
                case "/" -> left / right;
                case "+" -> left + right;
                case "-" -> left - right;
                default -> throw new IllegalArgumentException("Invalid operator: " + node.val);
            };
    }

    public static void main(String[] args){
        ExpressionTree et = new ExpressionTree();
        et.buildFromPostfix("4 2 6 - -");
        System.out.println(et.evaluate());
    }

}
