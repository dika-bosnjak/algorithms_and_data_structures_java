package BinaryHeaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class App {
    public static void main(String[] args) {

/*        Heap heap = new Heap();

        for (int i = 0; i < 1000; i++) {
            heap.insert(i);
        }

        heap.heapSort();*/

/*        // by default the heap is MIN heap
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        //O(logN)
        heap.add(12);
        heap.add(5);
        heap.add(7);
        heap.add(0);
        heap.add(-2);

        // O(N)
        heap.contains(0);

        //when we consider all N items in O(logN) = O(NlogN)
         while(!heap.isEmpty()) {
             //O(logN)
            System.out.println(heap.poll());
        }*/

/*        Queue<Person> heap = new PriorityQueue<>(Collections.reverseOrder());

        //O(logN)
        heap.add(new Person("Dika", 23));
        heap.add(new Person("Adam", 22));
        heap.add(new Person("Jane", 45));
        heap.add(new Person("Jake", 38));

        //when we consider all N items in O(logN) = O(NlogN)
        while (!heap.isEmpty()) {
            //O(logN)
            System.out.println(heap.poll());
        }*/

        MinHeap heap = new MinHeap();

        for (int i = 0; i < 1000; i++) {
            heap.insert(i);
        }

        heap.heapSort();
    }
}
