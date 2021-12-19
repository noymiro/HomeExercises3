public class Exe4 {

    public static void main(String[] args) {
        int[] array = {63, 65, 62, 64, 61};
        System.out.println(checkFullArray(array));
        int[] downArray = {5, 4, 3, 2, 1};
        System.out.println(checkDownArray(downArray));
    }


    public static boolean checkFullArray(int[] array) {
        boolean fullArray = false;
        int value = 0;
        int lower = 0;
        int higher = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] < array[i]) {
                    higher = array[j];
                    lower = array[i];
                    array[i] = higher;
                    array[j] = lower;
                }
                if (array[j] > array[i]) {
                    higher = array[i];
                    lower = array[j];
                    array[i] = lower;
                    array[j] = higher;
                }
            }
        }
        int j = 0;
        for (int i = 1; i <= array.length - 1; i++) {
            if (array[j] + 1 == array[i]) {
                fullArray = true;
                j++;
            } else {
                fullArray = false;
                break;
            }
        }
        return fullArray;
    }

    public static boolean checkDownArray(int[] downArray) {
        boolean isDownCompleteArray = false;
        int j = 0;
        for (int i = 1; i <= downArray.length - 1; i++) {
            if (downArray[j] - 1 == downArray[i]) {
                isDownCompleteArray = true;
                j++;
            } else {
                isDownCompleteArray = false;
                break;
            }
        }
        return isDownCompleteArray;

    }
}
