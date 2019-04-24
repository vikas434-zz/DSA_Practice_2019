public class BinaryTree {

    int value;

    BinaryTree root;

    BinaryTree left;

    BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
    }

    // Left -> Root -> Right
    public void inOrderTravel(final BinaryTree root) {

        if(null == root) {
            return;
        }

        inOrderTravel(root.left);

        System.out.println(root.value);

        inOrderTravel(root.right);
    }

    // Le
    public void preOrderTravel(final BinaryTree root) {

    }
}
