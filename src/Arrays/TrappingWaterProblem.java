package Arrays;

public class TrappingWaterProblem {

    public static void main(String[] args) {
        //int[] bars = {4,1,3,1,5};
        int[] bars = {2,1,3,1,4};
        //set last units as the first bar in the array
        int lastUnits = bars[0];
        //set default value for water units
        int waterUnits = 0;
        //if there is less than three bars, return just 0
        if (bars.length < 3) {
            System.out.println(0);
        } else {
            for (int i = 1; i < bars.length; i++) {
                //if current height of bar is smaller than the previous one
                if(bars[i] < lastUnits) {
                    //fill it with value to make it equal
                    int currentWaterUnit = lastUnits - bars[i];
                    //add current water units to the sum
                    waterUnits = waterUnits + currentWaterUnit;
                    //set last units value to the current height of bar plus the current water units
                    lastUnits = bars[i] + currentWaterUnit;
                }
                //if current height of bar is bigger or equal to the previous one, just set the lastUnits value
                else {
                    lastUnits = bars[i];
                }
            }
        }
        System.out.println(waterUnits);
    }
}
