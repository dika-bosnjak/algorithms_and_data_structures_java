package Stack.MaxInStackProblem;

public class App {
    public static void main(String[] args) {

        MaxItemStack maxItemStack = new MaxItemStack();

        maxItemStack.push(10);
        maxItemStack.push(5);
        maxItemStack.push(1);
        maxItemStack.push(12);
        maxItemStack.push(11);

        System.out.println(maxItemStack.getMaxItem());
    }
}
