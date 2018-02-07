package Tree;

import java.util.Stack;

public class IterativePreorderTraversal {
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
	
	public static void print(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.print(curr.val + ", ");
			if(curr.right != null)
				stack.push(curr.right);
			if(curr.left != null)
				stack.push(curr.left);
		}
	}
}
