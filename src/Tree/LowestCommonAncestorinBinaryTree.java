package Tree;

public class LowestCommonAncestorinBinaryTree {
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
	    TreeNode lcs = findLCA(root, new TreeNode(0), new TreeNode(0));
	    if(lcs != null)
	    		System.out.print("The LCA is " + lcs.val);  
	    else
	    		System.out.print("No LCA existed.");
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
}
