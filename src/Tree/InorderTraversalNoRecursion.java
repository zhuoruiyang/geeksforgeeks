package Tree;

import java.util.Stack;

public class InorderTraversalNoRecursion {
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
		stack.push(root);
		TreeNode curr = null;
		if(root.left != null)
			curr = root.left;
		else if(root.right != null)
			curr = root.right;
		while(!stack.isEmpty() || curr != null) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.val + ", ");
			curr = curr.right;
		}
	}
}
