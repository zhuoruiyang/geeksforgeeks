package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
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
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			sb.append(", " +  curr.val);
			if(curr.left != null)
				queue.add(curr.left);
			if(curr.right != null)
				queue.add(curr.right);
		}
		System.out.print(sb.reverse().toString());
	}
}
