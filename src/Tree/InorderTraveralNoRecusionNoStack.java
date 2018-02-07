package Tree;

public class InorderTraveralNoRecusionNoStack {
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
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.val + ", ");
				curr = curr.right;
			}
			else {
				TreeNode predecessor = curr.left;
				while(predecessor.right != curr && predecessor.right != null) {
					predecessor = predecessor.right;
				}
				if(predecessor.right == null) {
					predecessor.right = curr;
					// for preorder Morris Traversal
//					System.out.print(curr.val + ", ");
					curr = curr.left;
				}
				else {
					predecessor.right = null;
					System.out.print(curr.val + ", ");
					curr = curr.right;
				}
			}
		}
	}
}
