package Tree;
/*
 * A helper class for practicing tree-related question
 */
// A Binary Tree Node
class TreeNode {
    int val;
    char key;
    TreeNode left;
    TreeNode right;
     
    // constructor
    TreeNode (int val) {
        this.val = val;
        left = null;
        right = null;
    }
    
    TreeNode (char key) {
    		this.key = key;
    		left = null;
    		right = null;
    }
}
