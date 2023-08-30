class Calculator {
    int calculate(int a1, int b1, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a1 + b1;
            case "-":
                return a1 - b1;
            case "*":
                return a1 * b1;
            case "/":
                if (b1 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a1 / b1;
            default:
                throw new Exception("Не верный знак операции");
        }
    }
}