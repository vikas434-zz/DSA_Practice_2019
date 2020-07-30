package leetCodeTop100Liked.easy;

/**
 * https://leetcode.com/problemset/top-100-liked-questions/?difficulty=Easy
 */

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * <p>
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */
public class P67MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 != null) {
            return t2;
        } else if (t1 != null && t2 == null) {
            return t1;
        } else if (t1 == null) {
            return null;
        } else {
            return mergeNotNullTrees(t1, t2);
        }

    }

    private TreeNode mergeNotNullTrees(TreeNode t1, TreeNode t2) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = t1.val + t2.val;
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);

        return treeNode;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

