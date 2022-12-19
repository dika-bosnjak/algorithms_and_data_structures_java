package Arrays;

import java.util.ArrayList;

public class ArrayListClass {

    public static void main(String[] args) {

        //ArrayLists use standard arrays under the hood (default capacity is 10
        ArrayList<String> names = new ArrayList<String>();

        //add new element at the end of array, complexity O(1)
        names.add("John");
        names.add("Jake");
        names.add("Anna");

        //get the value from a specific position, complexity O(1)
        System.out.println(names.get(0));

        //remove the element on the arbitrary position (not the last one), complexity O(n)
        names.remove(0);

        System.out.println("Number of elements in the array: " + names.size());

        for(String name : names) {
            System.out.println(name);
        }
    }
}
