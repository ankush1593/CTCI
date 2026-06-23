package CTCI.java.Chapter04_Trees_Graphs.HeapInsertionAndMinExtraction;

public class Solution {

    private int[] minHeap;
    private  int size;
    private  int capactiy;
    
    public Solution(int capactiy){
        this.capactiy = capactiy;
        this.minHeap = new int[capactiy];
    }

    public void insert(int data){
        if (size == capactiy){
            throw new RuntimeException("Heap is full");
        }
        minHeap[size] = data;
        int current = size;
        size++;
        while (current >0 && minHeap[current] < minHeap[getParent(current)] ) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public int extractMin(){
        if (size == 0){
            throw new RuntimeException("Heap is empty");
        }
        int min = minHeap[0];
        minHeap[0] = minHeap[size-1];
        size--;
        heapifyDown(0);
        return min;
    }

    public void heapifyDown(int index){
        int smallest = index;
        int left = getLeftChild(index);
        int right = getRightChild(index);

        if (left < size && minHeap[left] < minHeap[smallest]){
            smallest = left;
        }

        if (right < size && minHeap[right] < minHeap[smallest]){
            smallest = right;
        }

        if (smallest != index){
            swap(smallest, index);
            heapifyDown(smallest);
        }
    }

    private int getParent(int index){
        return (index-1)/2;
    }

    private int getLeftChild(int index){
        return 2*index+1;
    }

    private int getRightChild(int index){
        return 2*index+2;
    }

    private void swap(int a, int b){
        int temp = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = temp;
    }

    public static void main(String[] args) {

        Solution heap = new Solution(10);

        // Insert elements
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(40);

        System.out.println("Extracting elements in sorted order:");

        // Extract elements one by one
        while (true) {
            try {
                int min = heap.extractMin();
                System.out.print(min + " ");
            } catch (RuntimeException e) {
                break; // heap is empty
            }
        }
    }

    /* Trying with pointer implementation which is generally not used for heaps.
    public void insert(Node node){
        Node rightMost = getRightmostElement();
        Node currentNode;
        if (rightMost.left == null && rightMost.right == null){
            Node leftMost = getLeftmostElement();
            leftMost.left = node;
            currentNode = leftMost.left;
        }else if (rightMost.left == null){
            rightMost.left = node;
            currentNode = rightMost.left;
        }else{
            rightMost.right = node;
            currentNode = rightMost.right;
        }
        while ()

    }
    */
}