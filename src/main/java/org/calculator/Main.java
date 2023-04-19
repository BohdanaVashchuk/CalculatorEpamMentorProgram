package org.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Main {
    final static Logger logger = LogManager.getLogger(Main.class);
    private static Number res;
    private static Double resultOfDivision;
    private static Double firstNum;
    private static Double secondNum;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        logger.info("Let's enter your first number:");
        try {
            firstNum = input.nextDouble();
            checkBoundaryValue(firstNum);
        } catch (Exception exception) {
            logger.error("Data that was entered is not a number");
            System.exit(0);
        }

        logger.info("Select an operator for further calculation: +, -, *, or /\"" + " We are working just with mentioned list of operators");
        char operator = input.next().charAt(0);

        logger.info("Let's enter your second integer number:");
        try {
            secondNum = input.nextDouble();
            checkBoundaryValue(secondNum);
        } catch (Exception exception) {
            logger.info("Data that was entered is not a number");
            System.exit(0);
        }


        if (((firstNum == Math.floor(firstNum)) && !Double.isInfinite(firstNum)) &&
                ((secondNum == Math.floor(secondNum)) && !Double.isInfinite(secondNum))) {
            CalculatorInteger calculator = new CalculatorInteger();
            process(operator, calculator);
        } else {
            CalculatorDouble calculatorDouble = new CalculatorDouble();
            process(operator, calculatorDouble);
        }
    }

    public static void returnResult(Number result) {
        logger.info("Your result is " + result);
    }

    public static void checkBoundaryValue(Double number) {
        if (number > 20 || number < -20) {
            logger.error("Sorry entered value can not be calculated, find another calc" + number);
            System.exit(0);
        }
    }

    public static void resultDivision(Double result) {
        logger.info("Your result is " + result);
    }

    public static void process(char operator, FunctionsCalculator calculator) {
        switch (operator) {
            case '+':
                res = calculator.addition(firstNum, secondNum);
                returnResult(res);
                break;
            case '-':
                res = calculator.subtraction(firstNum, secondNum);
                returnResult(res);
                break;
            case '/':
                resultOfDivision = calculator.division(firstNum, secondNum);
                resultDivision(resultOfDivision);
                break;
            case '*':
                res = calculator.multiplication(firstNum, secondNum);
                returnResult(res);
                break;
            default:
                logger.info("Sorry but we don`t have answer for you as not operator was used\nUse any of mentioned operators instead of " + operator);
        }
    }
}