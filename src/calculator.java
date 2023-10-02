import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (a + b, a - b, a * b или a / b), где a и b - числа от 1 до 10:");
        String input = scanner.nextLine();
        try {
            String result = calculator.calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
    }
    private static String calc(String input) throws Exception {
        if (input.matches("^\\d{1,2}\\s*([+\\-/\\*])\\s*\\d{1,2}$")) {
            String[] tokens = input.split("\\s*([+\\-/\\*])\\s*");
            int a = Integer.parseInt(tokens[0]);
            char operation = input.replaceAll("\\d|\\s", "").charAt(0);
            int b = Integer.parseInt(tokens[1]);
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new Exception("Неверные числа.");
            } else {
                switch (operation) {
                    case '+':
                        return String.valueOf(a + b);
                    case '-':
                        return String.valueOf(a - b);
                    case '*':
                        return String.valueOf(a * b);
                    case '/':
                        if (b == 0) {
                            throw new Exception("Деление на ноль.");
                        } else {
                            return String.valueOf(a / b);
                        }
                }
            }
        } else {
            throw new Exception("Неверный формат ввода.");
        }
        return null;
    }
}