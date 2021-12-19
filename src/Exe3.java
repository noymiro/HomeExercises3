import java.util.Scanner;

public class Exe3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number1 = scanner.nextInt();
        int[] allPrimary = primeNumbers(number1);
        for (int i = 0; i < allPrimary.length; i++) {
            System.out.print(allPrimary[i] + ",");
        }
    }

    public static int[] primeNumbers(int prime) {
        int number = 0;
        int[] array = new int[prime];
        if (prime < 10) {
            array[0] = prime;
            return array;
        }
        for (int i = 2; i <= prime; i++) {
            while (prime % i == 0) {
                prime = prime / i;
                array[number] = i;
                number++;
                if (prime == i) {
                    array[number] = i;
                }
            }
        }
        int[] array2 = new int[number];
        for (int j = 0; j < number; j++) {
            array2[j] = array[j];
        }
        return array2;
    }
}

