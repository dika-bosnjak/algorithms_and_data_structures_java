package Queues.QueueImplementationWithStack;

import java.util.Stack;
public class Queue {

    private Stack<Integer> enqueueStack;

    private Stack<Integer> dequeueStack;

    public Queue() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    //adding an item O(1)
    public void enqueue(int item) {
        this.enqueueStack.push(item);
    }

    public int dequeue() {
        //if there is no elemnets in stacks
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            throw new RuntimeException("Stacks are empty...");
        }

        //if the dequeuestack is empty, add items from enqueue O(n)
        if (dequeueStack.isEmpty()) {

            while(!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        //otherwise, get element O(1)
        return dequeueStack.pop();
    }

}
