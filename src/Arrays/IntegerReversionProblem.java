package Arrays;

public class IntegerReversionProblem {

    public static void main(String[] args) {
        int number = 1234;
        System.out.println(number);
        int reversedNumber = reverseNumber(number);
        System.out.println(reversedNumber);
    }

    private static int reverseNumber(int number) {
        int newNumber = 0;
        while(number > 0) {
            int newDigit = number % 10;
            newNumber = newNumber * 10 + newDigit;
            number = number / 10;
        }
         return newNumber;
    }
}
