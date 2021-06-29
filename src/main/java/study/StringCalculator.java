package study;

import static java.lang.Integer.*;

import java.util.Scanner;

/**
 * 문자열 계산기
 */
public class StringCalculator {

    private int result;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String value = scanner.nextLine();

        final StringCalculator calculator = new StringCalculator();
        final int result = calculator.calculate(value);
        System.out.println("result = " + result);
    }

    public int calculate(String string) {
        final String[] strings = string.split(" ");
        checkArgumentsCount(strings);
        initializeVariables();
        result = parseInt(strings[0]);
        for (int i = 1; i < strings.length - 1; i += 2) {
            result = applyOperator(strings[i], parseInt(strings[i + 1]));
        }
        return result;
    }

    private void checkArgumentsCount(String[] strings) {
        if (strings.length % 2 != 1) throw new IllegalArgumentException();
    }

    private void initializeVariables() {
        result = 0;
    }

    private int applyOperator(String operator, int number) {
        if ("+".equals(operator)) return result + number;
        if ("-".equals(operator)) return result - number;
        if ("*".equals(operator)) return result * number;
        if ("/".equals(operator)) return result / number;
        throw new IllegalArgumentException();
    }
}
