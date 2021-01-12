package leetCodeTop100Liked.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode.P129SumRootToLeafNumbers;

/**
 * Created by vranjan on 2020-11-24
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 *
 *
 */
//TODO
public class P1302DeepestLeavesSum {
//    public int deepestLeavesSum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        List<Integer> list = new ArrayList<>();
//        inorderTraversal(list, root);
//        return firstAndLastSum(list);
//    }
    
//     public int deepestLeavesSum(TreeNode root) {
//       if (root == null) {
//            return 0;
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
//        return sum;
//    }
    
    public int deepestLeavesSum(TreeNode root) {
       if (root == null) {
            return 0;
        }
        int sum = 0;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            if(node.left == null && node.right == null) {
                sum+=node.val;
            }
        }
        return sum;
    }

    private int firstAndLastSum(final List<Integer> tree) {
        if (tree.size() > 1) {
            int first = tree.get(0);
            int last = tree.get(tree.size() - 1);
            return first + last;
        }
        else {
            return tree.get(0);
        }
    }

    private void inorderTraversal(final List<Integer> list, final TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(list, root.left);
        list.add(root.val);
        inorderTraversal(list, root.right);
    }
    
    public class TreeNode {
      int val;
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

// Note :- the first approach tried was on using in order traversal (L,N,R) this gives the first and the last node. 
// It worked for skewed tree, but failed for tree which is full at bottom level.

// Hence trying level order traversal for the last layer and sum of that.
// 2nd approach also failed because, those nodes having no leaves even at the non-bottom layer are also calculated in this.

// 3rd approach is to do level order traversal and print the sum of the last layer.