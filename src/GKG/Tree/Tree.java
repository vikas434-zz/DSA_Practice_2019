package GKG.Tree;

import java.util.LinkedList;

public class Tree {

    int value;

    Tree left;

    Tree right;

    public Tree(int value) {
        this.value = value;
    }

    // Left -> Right -> root
    public static void preOrderTraversal(Tree root) {
        // System.out.println("Printing pre order");
        if(root == null) {
            return;
        }

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);

        System.out.println("Printing pre order "+root.value);
    }

    // Root -> Left -> Right
    public static void postOrderTraversal(Tree root) {
        // System.out.println("Printing post order");
        if(root == null) {
            return;
        }

        System.out.println("Printing post order :: "+root.value);

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);
    }

    // Left -> Root -> Right
    public static void inOrderTraversal(Tree root) {
        // System.out.println("Printing in order");
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left);

        System.out.println("Printing inorder root :: "+root.value);

        inOrderTraversal(root.right);
    }

    public static void levelOrderTraversal(Tree root) {
        if(root == null) {
            return;
        }

        LinkedList<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final Tree insertedTree = queue.poll();
            if(insertedTree == null) {
                return;
            }
            System.out.println("Level order :: " + insertedTree.value);
            queue.add(insertedTree.left);
            queue.add(insertedTree.right);
        }
    }
}
