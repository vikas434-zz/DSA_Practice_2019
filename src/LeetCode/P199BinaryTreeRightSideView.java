package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vranjan
 * created 19/08/2021
 */
//TODO binary tree right side view
public class P199BinaryTreeRightSideView {
    int level = 0;
    public List<Integer> rightSideView(TreeNode root) {

        final List<Integer> rightSideList = new ArrayList<>();
        // Null case
        if(null == root) {
            return rightSideList;
        }
        rightSideListHelper(rightSideList, root, 1);
        // Try BFS or recursion
        return rightSideList;
    }

    private void rightSideListHelper(List<Integer> rightSideList, TreeNode root, int levelMax) {
        if(root == null) {
            return;
        }
        if(level < levelMax) {
            rightSideList.add(root.val);
            level = levelMax;
        }
        rightSideListHelper(rightSideList, root.right, levelMax+1);
        rightSideListHelper(rightSideList, root.left, levelMax+1);
    }

    public class TreeNode {
        int      val;
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
