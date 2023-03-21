package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Scanner;


public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public static double sum(double a, double b) {
        logger.info("[SUM]" + a + "+" +b);
        logger.info("[RESULT-SUM]" + (a+b));
        return (a+b);
    }
    public static double subtract(double a, double b) {
        logger.info("[SUBTRACT]" + a + "-" +b);
        logger.info("[RESULT-SUBTRACT]" + (a-b));
        return (a-b);
    }
    public static double multiply(double a, double b) {
        logger.info("[MULTIPLY]" + a + " * " +b);
        logger.info("[RESULT-MULTIPLY]" + (a*b));
        if (b == 0)  return 0;
        return (a*b);
    }
    public static double divide(double a, double b) {
        logger.info("[DIVIDE]" + a + "/" +b);
        logger.info("[RESULT-DIVIDE]" + (a/b));
        if (b == 0) throw new ArithmeticException();
        return (a/b);
    }
    public static int factorial(int number1) {
        logger.info("[FACTORIAL]" + number1);

        int result = 1;
        for(int i = 1; i <= number1; i++)
            result *= i;

        logger.info("[RESULT-FACTORIAL]" + result);
        return result;
    }

    public static double squareRoot(double number1) {
        logger.info("[SQ_ROOT]" + number1);
        double result = Math.sqrt(number1);
        logger.info("[RESULT-SQ ROOT]" + result);
        return result;
    }

    public static double power(double number1, double number2) {
        logger.info("[POWER]" + number1 + "^" + number2);
        double result = Math.pow(number1,number2);
        logger.info("[RESULT-POWER]" + result);
        return result;
    }

    public static double naturalLog(double number1) {
        logger.info("[NATURAL_LOG]" + number1);
        double result = Math.log(number1);
        logger.info("[RESULT-NATURAL_LOG]" + result);
        return result;
    }

        public static boolean twoInputs(double ar[]) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\nEnter Operand 1: ");
            ar[0] = sc.nextDouble();
            System.out.println("\nEnter Operand 2: ");
            ar[1] = sc.nextDouble();
            return true;
        }
        catch (InputMismatchException e) {
            logger.error("[EXCEPTION]" +e.toString()+ "\n[STACKTRACE]1" +
                    ""+ Arrays.toString(e.getStackTrace()));
            System.out.println("Please enter correct input");
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double inputArray[] = new double[2];
        double a, b;
        char ch= '5';
        int c;

        while(true) {
            while(true) {
                System.out.println("\nEnter Choice: \n 1. Addition \n 2. Subtraction \n 3. Multiply \n 4. Division \n 5. Factorial \n 6. Square Root \n 7. Power \n 8. Natural Logarithm \n 9. Exit");
                ch = (char) sc.nextByte();

                int flag = 1;
                switch (ch) {
                    case 1:
                        if(!twoInputs(inputArray)) break;
                        a = inputArray[0];
                        b = inputArray[1];
                        System.out.println("Sum of the operands = " + sum(a, b)+"\n");
                        break;
                    case 2:
                        if(!twoInputs(inputArray)) break;
                        a = inputArray[0];
                        b = inputArray[1];
                        System.out.println("Difference of the operands = " + subtract(a, b)+"\n");
                        break;
                    case 3:
                        if(!twoInputs(inputArray)) break;
                        a = inputArray[0];
                        b = inputArray[1];
                        System.out.println("Multiplication of the Operands = " + multiply(a, b)+"\n");
                        break;
                    case 4:
                        if(!twoInputs(inputArray)) break;
                        a = inputArray[0];
                        b = inputArray[1];
                        try {
                            System.out.println("Division of the Operands = " + divide(a, b)+"\n");
                        }catch (ArithmeticException e) {
                            logger.error("[EXCEPTION] - " +e.toString()+ "\n[STACKTRACE] - "+ Arrays.toString(e.getStackTrace()));
                            System.out.println("Division with 0 not allowed");
                        }
                        break;
                    case 5:
                        // find factorial
                        c = -1;

                        // Keep executing do-while loop till user enters a non-negative integer
                        while (c < 0) {
                            try {
                                System.out.print("Enter a non-negative integer operand : ");
                                c = sc.nextInt();

                                if (c< 0)
                                    System.out.println("Factorial is invalid for negative integers");
                                else
                                    System.out.println("Factorial of operand = " + factorial(c) + "\n");
                            }
                            // To handle cases where user enters non-numeric input
                            catch (InputMismatchException e) {
                                System.out.println("Factorial is invalid for negative integers");
                            }
                            sc.nextLine(); // Clear the buffer to receive new input
                        }

                        break;
                    case 6:
                        // find square root
                        a = -1;

                        // Keep executing do-while loop till user enters a non-negative number
                        while (a < 0) {
                            try {
                                System.out.print("Enter a non-negative number operand: ");
                                a = sc.nextDouble();

                                if (a < 0)
                                    System.out.println("Square Root is invalid for negative numbers");
                                else
                                    System.out.println("Square Root of operand = " + squareRoot(a) + "\n");
                            }
                            // To handle cases where user enters non-numeric input
                            catch (InputMismatchException e) {
                                System.out.println("Square Root is invalid for negative numbers");
                            }
                            sc.nextLine(); // Clear the buffer to receive new input
                        }

                        break;
                    case 7:
                        while(!twoInputs(inputArray)){}
                        a = inputArray[0];
                        b = inputArray[1];
                        System.out.println("power of the operands = " + power(a, b)+"\n");
                        break;
                    case 8:
                        a = 0;

                        // Keep executing do-while loop till user enters a positive number
                        while (a <= 0) {
                            try {
                                System.out.print("Enter a positive operand : ");
                                a= sc.nextDouble();

                                if (a <= 0)
                                    System.out.println("Natural Logarithm is invalid for negative numbers");
                                else
                                    System.out.println("Natural Logarithm of operands =" + naturalLog(a) + "\n");
                            }
                            // To handle cases where user enters non-numeric input
                            catch (InputMismatchException e) {
                                System.out.println("Natural Logarithm is invalid for negative numbers");
                            }
                            sc.nextLine(); // Clear the buffer to receive new input
                        }

                        break;




                    case 9:
                        return;
                    default:
                        flag =0;
                        System.out.println("Please Choose a correct Option");
                }
                if(flag == 1) break;
            }
            System.out.println("\nPress y to continue, anything else to exit");
            ch = sc.next().charAt(0);

            if(ch != 'Y' && ch != 'y') return ;
        }
    }
}