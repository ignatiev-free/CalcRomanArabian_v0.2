import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine().toUpperCase();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        char[] expression = input.toCharArray();
        int operatorIndex = -1;
        int operatorCount = 0;

        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/') {
                operatorCount++;
                if (operatorCount > 1) {
                    throw new IllegalArgumentException("Недопустимое значение.");
                }
                operatorIndex = i;
            }
        }

        if (operatorCount == 0 || operatorIndex == 0 || operatorIndex == expression.length - 1) {
            throw new IllegalArgumentException("Неверный формат выражения.");
        }

        String num1Str = input.substring(0, operatorIndex);
        String num2Str = input.substring(operatorIndex + 1);

        boolean isRoman = false;
        int a1, b1;

        try {
            a1 = Integer.parseInt(num1Str);
            b1 = Integer.parseInt(num2Str);

            if (a1 < 1 || a1 > 10 || b1 < 1 || b1 > 10) {
                throw new IllegalArgumentException("Я гуманитарий, больше 10 - это сложно.");
            }
        } catch (NumberFormatException e) {
            isRoman = true;

            if (!isRomanNumeral(num1Str) || !isRomanNumeral(num2Str)) {
                throw new IllegalArgumentException("Римские числа должны быть в диапазоне I-X.");
            }

            a1 = RomanToArabic.convert(num1Str);
            b1 = RomanToArabic.convert(num2Str);
        }

        String operator = String.valueOf(expression[operatorIndex]);
        Calculator calculator = new Calculator();
        int result = calculator.calculate(a1, b1, operator);

        if (isRoman) {
            if (result <= 0) {
                throw new IllegalArgumentException("Римские не умеют в ноль и в минус");
            }
            return ArabicToRoman.convert(result);
        } else {
            return String.valueOf(result);
        }
    }

    public static boolean isRomanNumeral(String input) {
        return input.matches("^(I|II|III|IV|V|VI|VII|VIII|IX|X)$");
    }
}
