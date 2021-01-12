package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
// My Approach was to use DFS and then print stack, but it was too long. Just recursive solution helped.
public class P129SumRootToLeafNumbers {

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int total;

    public int sumNumbers(TreeNode root) {

        total = 0;
        helper(root, 0);
        return total;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            total = total + sum;
            return;
        }


        helper(root.left, sum);
        helper(root.right, sum);
    }

    // NLR
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    // LRN
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }


        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    // LNR
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }


        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // Level order traversal (BFS)
//    public void levelOrderModifiedforP1302(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        int sum = 0;
//
//        final Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left != null) {
//                queue.add(node.left);
//            }
//            if(node.right != null) {
//                queue.add(node.right);
//            }
//            if(node.left == null && node.right == null) {
//                sum+=node.val;
//            }
//        }
//
//    }


}
