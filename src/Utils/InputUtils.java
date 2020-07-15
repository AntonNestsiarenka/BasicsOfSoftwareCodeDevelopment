package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    public static int inputUInt(String str, Scanner scanner) {
        // Метод для ввода целочисленного положительного значения из консоли.
        System.out.print(str);
        int number;
        try {
            number = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            scanner.nextLine();
            return inputUInt(str, scanner);
        }
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUInt(str, scanner);
    }

    public static double inputDouble(String str, Scanner scanner) {
        // Метод для ввода действительного значения из консоли.
        System.out.print(str);
        double value;
        try {
            value = scanner.nextDouble();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается действительное число.");
            scanner.nextLine();
            return inputDouble(str, scanner);
        }
        return value;
    }

    public static int inputNaturalNumber(String str, Scanner scanner) {
        // Метод для ввода натурального числа из консоли.
        System.out.print(str);
        int number;
        try {
            number = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            scanner.nextLine();
            return inputNaturalNumber(str, scanner);
        }
        if (number > 0)
            return number;
        System.out.println("Число должно быть > 0.");
        return inputNaturalNumber(str, scanner);
    }
}
