import GKG.Tree.Tree;

public class KthLargestElementBinaryTree {
    public static void main(String[] args) {

    }

    public int findKLargestElement(Tree root, int k) {
        return kthLargestUtil(root, 0, k);
    }

    private int kthLargestUtil(Tree root, int i, int k) {
        int NOT_FOUND = -1;
        if(root == null) {
            return  NOT_FOUND;
        }

        // Searching in right subtree

        int result = kthLargestUtil(root.getRight(), i, k);

        if(result != NOT_FOUND) {
            return result;
        }

        if(++i == k) {
            return root.getValue();
        }

        // else search in left sub tree
        return kthLargestUtil(root.getLeft(), i, k);
    }
}
