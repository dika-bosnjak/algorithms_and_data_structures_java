package Arrays;

import java.util.Arrays;

public class ReverseArrayProblem {
    public static void main (String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(nums));
        int[] reverseNums = solve(nums);
        System.out.println(Arrays.toString(reverseNums));
    }

    //no need for extra memory (in-place algorithm) - O(N/2) = O(N) linear running time complexity
    public static int[] solve(int[] nums) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        
        while(lowIndex < highIndex) {
            swap(nums, lowIndex, highIndex);
            lowIndex++;
            highIndex--;
        }

        return nums;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
