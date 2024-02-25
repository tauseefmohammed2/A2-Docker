import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        if (args.length == 3) {
            double firstNumber;
            double secondNumber;
            char operator;

            try {
                firstNumber = Double.parseDouble(args[0]);
                operator = args[1].charAt(0);
                secondNumber = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
                return;
            }

            double result = calculate(firstNumber, secondNumber, operator);

            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f\n", result);
            } else {
                System.out.println("Invalid operation.");
            }
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator");
        System.out.print("Enter the first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNumber = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result = calculate(firstNumber, secondNumber, operator);

        if (!Double.isNaN(result)) {
            System.out.printf("Result: %.2f\n", result);
        } else {
            System.out.println("Invalid operation.");
        }

        scanner.close();
    }

    public static double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0) return Double.NaN; // Avoid division by zero
                return firstNumber / secondNumber;
            default:
                return Double.NaN; // Invalid operator
        }
    }
}