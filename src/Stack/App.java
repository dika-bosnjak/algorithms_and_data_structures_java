package Stack;

public class App {
    public static void main(String[] args) {
        StackList<String> names = new StackList<String>();

        names.push("Adam");
        names.push("Kevin");
        names.push("Ana");
        names.push("Jane");

        while(!names.isEmpty()) {
            System.out.println(names.pop());
        }

        StackArray<Integer> nums = new StackArray<>();
        nums.push(1);
        nums.push(2);
        nums.push(3);
        nums.push(4);
        nums.push(5);
        nums.push(6);

        while(!nums.isEmpty()) {
            System.out.println(nums.pop());
        }

    }
}
