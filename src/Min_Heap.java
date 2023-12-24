import java.util.Arrays;

class Min_Heap {
    private int[] HeapArray;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public Min_Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        HeapArray = new int[this.maxsize + 1];
        HeapArray[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return ( 2 * pos );
    }

    private int rightChild(int pos) {
        return (2 * pos ) + 1;
    }

    // checks if the node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = HeapArray[fpos];
        HeapArray[fpos] = HeapArray[spos];
        HeapArray[spos] = tmp;
    }

    private void minHeapify(int pos)  {
        // check if the node is non-leaf and greater than its child
        if (!isLeaf(pos)) {
            if (HeapArray[pos] > HeapArray[leftChild(pos)]
                    || HeapArray[pos] > HeapArray[rightChild(pos)]) {

                // swap with left child and then heapify the left child
                if (HeapArray[leftChild(pos)] < HeapArray[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // insert a node into the heap
    public void insert(int element)  {
        if (size >= maxsize) {
            return;
        }
        HeapArray[++size] = element;
        int current = size;

        while (HeapArray[current] < HeapArray[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        System.out.println(Arrays.toString(HeapArray));
    }

    // Function to print the contents of the heap
    public void display()  {
        System.out.println("PARENT NODE" + "\t" + "LEFT NODE" + "\t" + "RIGHT NODE");
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" " + HeapArray[i] + "\t\t" + HeapArray[2 * i]
                    + "\t\t" + HeapArray[2 * i + 1]);
            System.out.println();
        }
    }

    // build min heap
    public void minHeap()  {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // remove and return the heap elment
    public int remove()  {
        int popped = HeapArray[FRONT];
        HeapArray[FRONT] = HeapArray[size--];
        minHeapify(FRONT);
        return popped;
    }

    @Override
    public String toString() {
        return "Min_Heap{" +
                "HeapArray=" + Arrays.toString(HeapArray) +
                ", size=" + size +
                ", maxsize=" + maxsize +
                '}';
    }
}