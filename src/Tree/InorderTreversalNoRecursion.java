package Tree;

import java.util.Stack;

public class InorderTreversalNoRecursion {
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
		Stack<TreeNode> stack = new Stack<>();
		if(root.left != null)
			stack.push(root.left);
		stack.push(root);
		if(root.right != null)
			stack.push(root.right);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + ", ");
			if(node.left != null)
				stack.push(node.left);
			stack.push(node);
			if(node.right != null)
				stack.push(node.right);
		}
	}
}
