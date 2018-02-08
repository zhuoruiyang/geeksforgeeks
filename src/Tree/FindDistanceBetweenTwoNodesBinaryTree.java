package Tree;

public class FindDistanceBetweenTwoNodesBinaryTree {
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
	    TreeNode lca = findLCA(root, new TreeNode(2), new TreeNode(6));
	    int distance = calcDist(lca, new TreeNode(2), 0) + calcDist(lca, new TreeNode(6), 0);
	    	System.out.print("The distance between two nodes is " + distance);  
	}
	
	private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null)
			return null;
		if(root.val == node1.val || root.val == node2.val)
			return root;
		TreeNode leftLCA = findLCA(root.left, node1, node2);
		TreeNode rightLCA = findLCA(root.right, node1, node2);
		if(leftLCA != null && rightLCA != null)
			return root;
		return leftLCA == null ? rightLCA : leftLCA;
	}
	
	private static int calcDist(TreeNode root, TreeNode node, int dist) {
		if(root == null)
			return dist+1;
		if(root.val == node.val) 
			return dist;
		int dist1 = calcDist(root.left, node, dist+1);
		int dist2 = calcDist(root.right, node, dist+1);
		return dist1 < dist2 ? dist1 : dist2;
	}
}
