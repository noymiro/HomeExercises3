public class Exe1 {


    public static void main(String[] args) {
        int[] arr = {147, 101, 109, 23};
        int theSmallestSumIndex = theSmallSum(arr);
        System.out.println("The index with a smallest sum numbers is:  " + theSmallestSumIndex);
    }

    public static boolean checkSwitchNumber(int number) {
        boolean positiveNumber = false;
        int checkDigit;
        int checkNextDigit;
        if (number >= 0 && number <= 10) {
            positiveNumber = true;
        }
        if (number > 10) {
            for (int i = 0; number > 0; i++) {
                checkDigit = number % 10;
                number = number / 10;
                checkNextDigit = number % 10;
                if (checkDigit != checkNextDigit) {
                    positiveNumber = true;
                } else {
                    positiveNumber = false;
                    break;
                }
            }
        }
        return positiveNumber;
    }

    public static int theSmallSum(int[] arr) {
        int[] sumArr = new int[arr.length];
        int numberInArray;
        int i;
        int theSmallestSumIndex = 0;
        for (i = 0; i < arr.length; i++) {
            numberInArray = arr[i];
            if (checkSwitchNumber(arr[i]) == true) {
                int sum = 0;
                while (numberInArray >= 1) {
                    sum = sum + numberInArray % 10;
                    numberInArray = numberInArray / 10;
                    sumArr[i] = sum;
                }
            }
        }
        for (i = 0; i < sumArr.length; i++) {
            if (sumArr[theSmallestSumIndex] >= sumArr[i]) {
                theSmallestSumIndex = i;
            }
        }
        return theSmallestSumIndex;
    }
}


