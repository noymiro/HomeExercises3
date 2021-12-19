import java.util.Scanner;

public class Exe7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a equation");
        String equation = scanner.next();
        calculatingTheEquation(equation);

    }

    public static void calculatingTheEquation(String str) {
        int a;
        int b;
        int c;
        int count = 0;
        char[] equation = new char[str.length()];
        for (int i = 0; i < equation.length; i++) {
            equation[i] = str.charAt(i);
            if (equation[i] >= '0' && equation[i] <= '9') {
                count++;
            }
            if (equation[1] == 'x' && equation[2] == '^' && equation[3] == '2' && equation[4] == '+' && equation[6] == 'x'
                    && equation[7] == '+' && equation[9] == '=' && equation[10] == '0' && count == 5) {
                a = equation[0] - 48;
                b = equation[5] - 48;
                c = equation[8] - 48;
                solutionOfTheEquation(a, b, c);
            }
        }
        if (str.length() < 11) {
            System.out.println("The equation is wrong");
        } else if (str.length() > 11) {
            System.out.println("The equation is wrong");
        }


    }


    public static void solutionOfTheEquation(int a, int b, int c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("There are no solutions");
        } else if (delta == 0) {
            System.out.println("There is one answer: " + -b / (2 * a));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("The Solutions are: " + x1 + ", " + x2);
        }
    }
}
