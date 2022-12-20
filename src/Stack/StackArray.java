package Stack;

public class StackArray<T> {

    private int count;
    private T[] stack;

    public StackArray() {
        stack = (T[]) new Object[1];
    }

    //O(1)
    public void push(T newData) {
        if (count == stack.length) {
            resize(2*count);
        }

        stack[count++] = newData;
    }

    //returns and removes the last item we have inserted O(1)
    public T pop() {
        if(isEmpty()) return null;

        T item = stack[--count];
        //obsolete references - avoid memory leaks
        stack[count] = null;

        //maybe we have to resize the array and decrease the size
        if (count > 0 && count == stack.length / 4) {
            resize(stack.length/2);
        }

        return item;
    }

    //O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    //size  method in O(1)
    public int size() {
        return count;
    }

    //this is the bottleneck of the application O(N)
    private void resize(int capacity) {
        System.out.println("resizing...");
        T[] stackCopy = (T[]) new Object[capacity];

        for(int i = 0; i < count; i++) {
            stackCopy[i] = stack[i];
        }

        stack = stackCopy;
    }
}
