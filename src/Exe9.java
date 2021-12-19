import java.util.Scanner;

public class Exe9 {
    public static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        int[] code = new int[4];
        code = getRandomPassword(code, 0);
        printMission();
        int perfectGuess = 0;
        int choice = userChoice();
        track(choice, perfectGuess, code);
    }

    public static int[] getRandomPassword(int[] password, int index) {
        int theLowestNumber = 1;
        int theHighestNumber = 6;
        if (index < 4) {
            int nextNumber;
            for (nextNumber = randomNumber(theLowestNumber, theHighestNumber);
                 appearsSeveralTimes(password, nextNumber);
                 nextNumber = randomNumber(theLowestNumber, theHighestNumber)) {
            }

            password[index] = nextNumber;
            getRandomPassword(password, index + 1);
        }

        return password;
    }

    public static int randomNumber(int theLowestNumber, int theHighestNumber) {
        int randomNumber = (int) (Math.random() * (theHighestNumber - theLowestNumber + 1) + theLowestNumber);
        return randomNumber;
    }

    public static void printMission() {
        System.out.println("To win you have to guess the random secret code generated.\n" +
                "Code between 4 digits, and numbers between 1-6");
        System.out.println("Please tap the track you would like to play:\n" +
                "1. Easy track: 20 opportunities.\n" +
                "2. Medium track: 15 opportunities.\n" +
                "3. Hard track: 10 opportunities.\n" +
                "4. Surprising track: The number of opportunities is drawn between the values 5-25.");
    }

    public static int userChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please enter a number of track,between 1-4:");
            choice = scanner.nextInt();
        } while (notInRange(choice, 5, 0));

        return choice;
    }

    public static int track(int userChoice, int correct, int[] password) {
        int chances = 0;
        switch (userChoice) {
            case 1:
                chances = 20;
                break;
            case 2:
                chances = 15;
                break;
            case 3:
                chances = 10;
                break;
            case 4:
                chances = randomNumber(25, 5);
        }
        int[] userGuess = new int[ARRAY_SIZE];
        int codeNumber;
        int accurateGuessing = 0;
        do {
            if (correct != 4) {
                System.out.println("You have " + chances + " chances \nGuess the code:");
            } else {
                System.out.println("Guess the code:");
            }

            Scanner scanner = new Scanner(System.in);
            codeNumber = scanner.nextInt();
            if (notInRange(codeNumber, 6666, 1111)) {
                System.out.println("Guess the code:");
            } else if (correct(userGuess, codeNumber)) {
                accurateGuessing = perfectGuess(password, userGuess);
                chances--;
            } else {
                chances -= 2;
            }
        } while (!endOfGame(accurateGuessing, chances));

        return codeNumber;
    }

    public static int perfectGuess(int[] password, int[] userGuess) {
        int perfectGuess = 0;
        int partialGuess = 0;

        for (int i = 0; i < 4; ++i) {
            if (password[i] == userGuess[i]) {
                ++perfectGuess;
            } else {
                for (int j = 0; j < 4; ++j) {
                    if (userGuess[i] == password[j]) {
                        ++partialGuess;
                    }
                }
            }
        }

        if (perfectGuess == 4) {
            System.out.println("You guessed the code!! ");
        } else {
            System.out.println(" You have accurate guesses " + perfectGuess + " and " + partialGuess + " and partial guesses");
        }

        return perfectGuess;
    }

    public static boolean notInRange(int userChoice, int theHighestNumber, int theLowestNumber) {
        boolean notInRange = true;
        if (userChoice > theLowestNumber && userChoice < theHighestNumber) {
            notInRange = false;
        }

        return notInRange;
    }

    public static boolean appearsSeveralTimes(int[] password, int randomNumber) {
        boolean appearsSeveralTimes = false;

        for (int i = 0; i < password.length; ++i) {
            if (randomNumber == password[i]) {
                appearsSeveralTimes = true;
            }
        }

        return appearsSeveralTimes;
    }

    public static int[] userGuess(int[] guess, int numberGuess, int index) {
        while (index >= 0) {
            guess[index] = numberGuess % 10;
            numberGuess /= 10;
            --index;
            index = index;
            userGuess(guess, numberGuess, index);
        }

        return guess;
    }

    public static boolean correct(int[] guess, int numberChoice) {
        guess = userGuess(guess, numberChoice, 3);
        boolean correctNumber = true;

        for (int i = 0; i < 4; ++i) {
            if (!notInRange(guess[i], 7, 0)) {
                for (int j = i + 1; j < 4; ++j) {
                    if (guess[i] == guess[j]) {
                        correctNumber = false;

                    }
                }
            } else {
                System.out.println("The literature you selected is big\nPlease select again");
                correctNumber = false;
            }
        }

        return correctNumber;
    }

    public static boolean endOfGame(int track, int perfectGuess) {
        boolean endGame = false;
        if (perfectGuess < 0 || track == 4) {
            if (track != 4) {
                System.out.println("Sorry, game over");
            }

            endGame = true;
        }

        return endGame;
    }
}


