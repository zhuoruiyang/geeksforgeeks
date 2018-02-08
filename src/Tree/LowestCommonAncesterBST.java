package Tree;

public class LowestCommonAncesterBST {
	public static void main(String[] args) {
    // Let us create binary tree shown in above diagram
	   /*             4
	               /     \
	              2       5
	            /   \       \
	           1     3       6
	    */
		
		TreeNode root = new TreeNode(4);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(5);
	    root.left.left = new TreeNode(1);
	    root.left.right = new TreeNode(3);
	    root.right.right = new TreeNode(6);
	    TreeNode lcs = findLCA(root, new TreeNode(1), new TreeNode(6));
	    if(lcs != null)
	    		System.out.print("The LCA is " + lcs.val);  
	    else
	    		System.out.print("No LCA existed.");
	}
	
	private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null)
			return null;
		
		if(root.val > node1.val && root.val > node2.val)
			return findLCA(root.left, node1, node2);
		else if(root.val < node1.val && root.val < node2.val)
			return findLCA(root.right, node1, node2);
		
		return root;
	}
}
