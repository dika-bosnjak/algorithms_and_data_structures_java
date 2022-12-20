package Stack.MaxInStackProblem;

import java.util.Stack;

public class MaxItemStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public MaxItemStack() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int item) {
        //push new value to a main stack
        mainStack.push(item);

        //first item is the same in the both stacks
        if (mainStack.size() == 1) {
            maxStack.push(item);
            return;
        }

        //if the inserted value is the largest so far: insert it into max stack
        if(item > maxStack.peek()) {
            maxStack.push(item);
        } else {
            //if it is not the largest one, duplicate the largest value in the maxStack
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    //O(1)
    public int getMaxItem() {
        return maxStack.peek();
    }

    public Stack<Integer> getMainStack() {
        return mainStack;
    }

    public void setMainStack(Stack<Integer> mainStack) {
        this.mainStack = mainStack;
    }

    public Stack<Integer> getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(Stack<Integer> maxStack) {
        this.maxStack = maxStack;
    }
}
