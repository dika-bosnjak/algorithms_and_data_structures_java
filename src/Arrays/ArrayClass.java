package Arrays;

public class ArrayClass {

    public static void main(String[] args) {

        //arrays are not dynamic data structures - we have to define the size in advance
        int[] nums = new int[10];

        //insert items to a given location, complexity O(1)
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }

        //update the value on a specific index position, complexity O(1)
        nums[0] = 100;

        //update the value on unknown position - LINEAR SEARCH, complexity =(n)
        for (int i = 0; i < 10; i++) {
           if (nums[i] == 6) {
               System.out.println("Index of element that has value 6 is: " + i);
           }
        }

        for (int i = 0; i < 10; i++) {
            // print the value from a given location, complexity O(1)
            System.out.println(nums[i]);
        }
    }
}
