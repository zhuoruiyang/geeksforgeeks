package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class printLevelOrderTraversal {
	public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*               1
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
        printLOT(root);
	}
	
	private static void printLOT(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {		
			int numOfNodes = queue.size();
			StringBuilder sb = new StringBuilder();
			while(numOfNodes > 0) {
				TreeNode node = queue.poll();
				numOfNodes--;
				sb.append(node.val).append(", ");
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
				
			}
			System.out.println(sb.toString());
		}
	}
}
