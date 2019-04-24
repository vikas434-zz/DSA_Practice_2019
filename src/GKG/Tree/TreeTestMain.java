package GKG.Tree;

public class TreeTestMain {

    public static void main(String[] args) {
        Tree tree1 = new Tree(1);
        tree1.left = new Tree(2);
        tree1.right = new Tree(3);
        tree1.left.left = new Tree(4);
        tree1.left.right = new Tree(5);
        tree1.right.left = new Tree(6);
        tree1.right.right = new Tree(7);

        // PreOrder
        Tree.preOrderTraversal(tree1);

        // PostPrder
        Tree.postOrderTraversal(tree1);

        // InOrder
        Tree.inOrderTraversal(tree1);

        // Level Order
        Tree.levelOrderTraversal(tree1);
    }
}
