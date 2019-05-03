package LeetCode;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class P98ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void doInOrderTraversal(TreeNode root, Stack s) {
        if (root == null) {
            return;
        }
        doInOrderTraversal(root.left, s);
        s.push(root.val);
        doInOrderTraversal(root.right, s);

    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        doInOrderTraversal(root, stack);

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                return true;
            }
            int secondTop = stack.peek();
            if (top <= secondTop) {
                return false;
            }
        }
        return true;
    }
}
