package Tree;

import java.util.Stack;

public class IterativePostorderTraversalTwoStacks {
	public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*             1
                   /     \
                  2       3
                /   \       \
               4     5       6
        */
		
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        print(root);
	}
	
	private static void print(TreeNode root) {
		Stack<TreeNode> stackRev = new Stack<>();
		Stack<TreeNode> stackPostOrder = new Stack<>();
		stackRev.push(root);
		TreeNode curr = null;
		while(!stackRev.isEmpty()) {
			curr = stackRev.pop();
			stackPostOrder.push(curr);
			if(curr.left != null) 
				stackRev.push(curr.left);
			if(curr.right != null)
				stackRev.push(curr.right);
		}
		while(!stackPostOrder.isEmpty())
			System.out.print(stackPostOrder.pop().val + ", ");
	}
}
