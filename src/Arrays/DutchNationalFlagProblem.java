package Arrays;

import java.util.Arrays;
public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        //array consists of 0s, 1s and 2s
        int[] array = {0, 1, 2, 1, 2, 0, 0};
        int[] sortedArray = sortArray(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] sortArray(int[] nums) {
        int i = 0;
        int j = 0;
        int pivot = 1; //middle value
        int k = nums.length - 1; //the last element in the array

        //it has O(N) linear running time
        while(j <= k) {
            //check whether the value is 0
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            //check whether the value is 2
            else if(nums[j] > pivot){
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            }
            //check whether the value is 1
            else {
                j++;
            }
        }
        return nums;
    }


}
