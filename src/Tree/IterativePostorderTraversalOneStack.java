package Tree;

import java.util.Stack;

public class IterativePostOrderTraversalOneStack {
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
		if(root.right != null)
			stack.push(root.right);
		stack.push(root);
		root = root.left;
		TreeNode curr = null;
		while(!stack.isEmpty()) {
			while(root != null) {
				if(root.right != null)
					stack.push(root.right);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(!stack.isEmpty() && root.right == stack.peek()) {
				curr = stack.pop();
				stack.push(root);
				root = curr;
			}
			else {
				System.out.print(root.val + ", ");
				root = null;
			}
		}
	}
}
