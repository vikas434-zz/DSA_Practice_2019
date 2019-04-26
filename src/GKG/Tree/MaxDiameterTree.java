package GKG.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDiameterTree {

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);

        System.out.println("find height :: "+findHeight(tree));

        System.out.println("Max diameter of the tree is :: "+findMaxDiameter(tree));

        // TODO height calculation and diameter calculation is wrong.
        // Height :- 0 or 1+maxHeight(left,right)
        // Max diameter :- max(leftTreeDiameter, rightTreeDiameter, 1+leftSubTreeHeight+rightSubtreeHeight)

    }

    private static int findMaxDiameter(Tree root) {
        if(root == null) {
            return 0;
        }

        int maxDiameter = 0;

        // Do level order traversal of tree and keep finding the diameter each level and then get the max.

        LinkedList<Tree> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            final Tree node = queue.poll();
            if(node == null) {
                return maxDiameter;
            }
            int maxDiameterAtThisNode = findHeight(node.left) + findHeight(node.right) - 1;
            if(maxDiameterAtThisNode > maxDiameter) {
                maxDiameter = maxDiameterAtThisNode;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return maxDiameter;
    }

    private static int findHeight(Tree node) {
        if(node == null) {
            return 0;
        }

        // Leaf node.
        if((node.left == null) && (node.right == null)) {
            return 1;
        }

        return findHeight(node.left) + findHeight(node.right);
    }
}


