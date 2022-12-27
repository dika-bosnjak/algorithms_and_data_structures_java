package BinaryHeaps;

//MAX HEAP
public class Heap {

    //1D array representation
    private int[] heap;
    //num of items in the heap
    private int heapSize;

    public Heap() {
        heap = new int[Constants.CAPACITY];
    }

    public void insert(int data) {
        if (isFull()) throw new RuntimeException("Heap is full...");

        //append data to the end of the array
        heap[heapSize] = data;
        heapSize ++;

        //we have to check the heap properties - from the last item
        heapify(heapSize-1);

    }

    private void heapify(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            heapify(parentIndex);
        }
    }

    //O(1)
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    //O(1)
    public int getMax(){
        return heap[0];
    }

    //heapsort is doing a poll() for N times = O(NlogN)
    public void heapSort(){

        int n = heapSize;
        for (int i = 0; i < n; i++) {
            int max = poll();
            System.out.println(max);

        }
    }


    //remove and return the max item in O(logN)
    public int poll() {
        int maxItem = heap[0];
        swap(0, heapSize -1);
        heapSize--;
        heapifyDown(0);
        return maxItem;

    }

    private void heapifyDown(int i) {
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;

        //parent has always the largest value
        int largestValueIndex = i;

        //compare left child with the parent
        if (leftChildIndex < heapSize && heap[leftChildIndex] > heap[i]) {
            largestValueIndex = leftChildIndex;
        }

        //compare right child with the max(parent, leftChild)
        if (rightChildIndex < heapSize && heap[rightChildIndex] > heap[largestValueIndex]) {
            largestValueIndex = rightChildIndex;
        }

        //child is swapped with the parent (if the child is greater than the parent)
        if (i != largestValueIndex) {
            swap(i, largestValueIndex);
            heapifyDown(largestValueIndex);
        }


    }

    //O(1)
    public boolean isEmpty() {
       return heapSize == 0;
    }

    //O(1)
    private boolean isFull(){
        return heapSize == heap.length;
    }

}
