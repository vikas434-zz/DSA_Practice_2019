package leetCodeTop100Liked.easy;

/**
 * @author vranjan
 * created 26/10/2021
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class P101BinarySymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Checking recursively - the below solution is not working for the use case Input: root = [1,2,2,null,3,null,3]
        //Output: false
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        } else {
            return isSymmetric(root.left) && isSymmetric(root.right);
        }
    }

    public class TreeNode {
        int                                  val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


