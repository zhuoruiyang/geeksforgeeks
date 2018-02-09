package Tree;

public class ConstructTreefromInorderandPreorderTraversals {
	public static void main(String[] args) {
		ConstructTreefromInorderandPreorderTraversals binaryTree = new ConstructTreefromInorderandPreorderTraversals();
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        binaryTree.buildTree(in, pre, 0, pre.length-1);
        binaryTree.inorderPrintTree();
	}
	
	TreeNode root;
	public ConstructTreefromInorderandPreorderTraversals() {
		this.root = null;
	}
	
	private void buildTree(char[] inorder, char[] preorder, int start, int end) {
		this.root = buildTreeRec(inorder, preorder, start, end);
	}
	
	int preIdx = 0;
	private TreeNode buildTreeRec(char[] inorder, char[] preorder, int start, int end) {
		if(start > end) return null;
		TreeNode root = new TreeNode(preorder[preIdx++]);
		if(start == end) return root;
		int index = findIndex(inorder, root.key, start, end);
		root.left = buildTreeRec(inorder, preorder, start, index-1);
		root.right = buildTreeRec(inorder, preorder, index+1, end);
		return root;
	}
	
	private int findIndex(char[] inorder, char key, int start, int end) {
		int index = start;
		for(int i = start; i <= end; i++) {
			if(inorder[i] == key) {
				index = i;
				break;
			}	
		}
		return index;
	}
	
	private void inorderPrintTree() {
		if(this.root == null)
			return;
		inorderPrintTreeRec(this.root);
	}
	
	private void inorderPrintTreeRec(TreeNode root) {
		if(root == null) return;
		inorderPrintTreeRec(root.left);
		System.out.print(root.key + ", ");
		inorderPrintTreeRec(root.right);
	}
}
