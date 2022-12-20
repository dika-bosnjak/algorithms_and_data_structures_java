package Queues.JavaQueues;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        //FIFO
        Queue<Integer> queue = new LinkedList<>();

        // add() method inserts a new item into the queue in O(1)
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // element() we can return without removing the first item
        System.out.println(queue.element());
        System.out.println(queue.size());

        System.out.println("---------------------");

        // remove() method is a dequeue() method in O(1)
        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }
}
