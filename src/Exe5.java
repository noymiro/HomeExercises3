import java.util.Locale;

public class Exe5 {
    public static void main(String[] args) {
        String sentence = "Take this text and test it";
        sentence = replaceChars(sentence);
        System.out.println(sentence);
    }

    public static String replaceChars(String sentence) {
        sentence = sentence.toLowerCase(Locale.ROOT);
        char[] chars = new char[sentence.length()];
        int[] quantity = new int[sentence.length()];
        int count;
        char space = ' ';
        int theBiggestQuantity = 0;
        int theSecondBiggestQuantity = 0;
        char bigChar = 0;
        char secondBigChar = 0;

        for (int i = 0; i < sentence.length(); i++) {
            count = 0;
            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(i) == sentence.charAt(j)) {
                    count++;
                    chars[i] = sentence.charAt(i);
                    quantity[i] = count;
                    if (chars[i] == space) {
                        count = 0;
                    }
                }
            }
        }

        for (int i = 0; i < quantity.length; i++) {
            if (theBiggestQuantity <= quantity[i]) {
                theBiggestQuantity = quantity[i];
                bigChar = chars[i];
                quantity[i] = 0;
            }
        }

        for (int i = 0; i < quantity.length; i++) {
            if (theSecondBiggestQuantity <= quantity[i]) {
                theSecondBiggestQuantity = quantity[i];
                secondBigChar = chars[i];
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == bigChar) {
                chars[i] = secondBigChar;
            }
        }

        sentence = sentence.replace(bigChar, secondBigChar);
        return sentence;
    }
}

