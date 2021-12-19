public class Exe2 {
    public static void main(String[] args) {
        int[] array1 = {1234, 159, 333};
        int[] array2 = {1, 6, 19, 987, 65};
        int indexLocation = proximityLevel(array1, array2);
        System.out.println(indexLocation);

    }

    public static int brothers(int number) {
        int sum = 0;
        while (number / 10 != 0) {
            sum = sum + number % 10;
            number = number / 10;

        }
        return sum;
    }

    public static int proximityLevel(int[] array1, int[] array2) {
        int brotherResult;
        int totalEquals;
        int equals = 0;
        int[] array3 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            brotherResult = brothers(array1[i]);
            for (int j = 0; j < array2.length; j++) {
                if (equals == brothers(array2[i])) {
                    equals++;
                    array3[i] = equals;
                }
            }
        }
        totalEquals = array1.length;
        int index = array3[0];
        for (int k = 0; k < array3.length; k++) {
            if (index < array3[k]) {
                index = array3[k];
                totalEquals = k;
            }
        }
        return totalEquals;
    }
}

