package GKG.Tree;

public class MinHeapUsingArray {

    int size;
    int[] heapArray;
    int currentIndex = 0;

    public MinHeapUsingArray(int size) {
        this.size = size;
        heapArray = new int[size];
    }

    public int getMinElement() {
        return heapArray[0];
    }

    public boolean isFull() {
       return currentIndex == size -1;
    }

    public boolean isEmpty() {
        return currentIndex == 0;
    }

    // Element added at last.
    public void insertElement(int element) {
        if(!isFull()) {
            heapArray[currentIndex++] = element;
            heapifyUp();
        } else {
            throw new IllegalStateException("Heap is already full");
        }
    }

    // Element deleted is only node.
    public void deleteElement(int element) {
        if(!isEmpty()) {
            heapArray[0] = heapArray[currentIndex];
            heapArray[currentIndex--] = 0;
            heapifyDown();
        } else {
            throw new IllegalStateException("Heap is empty, can't be deleted");
        }

    }

    public void heapifyUp() {
        // Get last inserted element and its parent index;
        int childIndex = currentIndex;
        int parentIndex = getParent(childIndex);
        while (parentIndex != -1) {
            // Keep checking parent value with child and swap if required or break.
            if(heapArray[parentIndex] > heapArray[childIndex]) {
                break;
            }
            // Parent index value is less than child hence swapping.
            int temp = heapArray[parentIndex];
            heapArray[parentIndex] = heapArray[childIndex];
            heapArray[childIndex] = temp;

            // Make parentIndex as child and the compare with the parents.
            childIndex = parentIndex;
            parentIndex = getParent(childIndex);
        }
    }

    // Root might not have the lowest element, so exchange.
    public void heapifyDown() {
        int rootElement = heapArray[0];
        int leftElement = heapArray[getLeftChild(0)];
        int rightElement = heapArray[getRightChild(0)];

        int minChild = getMin(leftElement, rightElement);
        if(rootElement < minChild) {
            return;
        }
        // TODO add logic to compare with child and swap.
    }

    public int getParent(int childIndex) {
        int parentIndex = (childIndex-1)/2;
        if(parentIndex < 0) {
            return -1;
        }
        return heapArray[parentIndex];

    }

    public int getLeftChild(int parentIndex) {
        int leftChildIndex = (2*parentIndex)+1;
        if(leftChildIndex >= size) {
            return -1;
        }
        return heapArray[leftChildIndex];
    }

    public int getRightChild(int parentIndex) {
        int rightChildIndex = (2*parentIndex)+2;
        if(rightChildIndex >= size) {
            return -1;
        }
        return heapArray[rightChildIndex];
    }

    public void printHeapLevelOrder() {
        for(int i =0; i<=currentIndex; i++) {
            System.out.print(heapArray[i] + " -> ");
        }
    }

    public int getMin(int a, int b) {
        return a < b ? a : b;
    }
}
