package Tree;

public class BinarySearchTree {
	public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorderTraversal();
        TreeNode res = tree.search(10);
        if(res == null)
        		System.out.println("No key is found.");
        else
        		System.out.println("Key is in the tree.");
        tree.deleteKey(50);
        tree.inorderTraversal();
	}
	
	TreeNode root;
	public BinarySearchTree() {
		root = null;
	}
	
	private TreeNode search(int key) {
		return searchRec(this.root, key);
	}
	
	private TreeNode searchRec(TreeNode root, int key) {
		if(root == null) return null;
		if(root.val == key)
			return root;
		else if(root.val > key)
			return searchRec(root.left, key);
		else
			return searchRec(root.right, key);
	}
	
	private void insert(int key) {
		if(this.root == null)
			this.root = new TreeNode(key);
		else 
			this.root = insertRec(this.root, key);
	}
	
	private TreeNode insertRec(TreeNode root, int key) {
		if(root == null) 
			root = new TreeNode(key);
		else {
			if(root.val > key)
				root.left = insertRec(root.left, key);
			else
				root.right = insertRec(root.right, key);
		}
		return root;
	}
	
	private void deleteKey(int key) {
		this.root = deleteKeyRec(this.root, key);
	}
	
	private TreeNode deleteKeyRec(TreeNode root, int key) {
		if(root == null) return null;
		if(root.val == key) {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				root.val = findSuccessor(root.right);
				root.right = deleteKeyRec(root.right, root.val);
			}
		}
		else if(root.val > key){
			root.left = deleteKeyRec(root.left, key);
		}
		else {
			root.right = deleteKeyRec(root.right, key);
		}
		return root;
	}
	
	private int findSuccessor(TreeNode root) {
		int key = root.val;
		while(root != null)  {
			key = root.val;
			root = root.left;
		}
		return key;
	}

	private void inorderTraversal() {
		inorderTraversalRec(this.root);
	}

	private void inorderTraversalRec(TreeNode root) {
		if(root == null) return;
		inorderTraversalRec(root.left);
		System.out.print(root.val + ", ");
		inorderTraversalRec(root.right);
	}
}
