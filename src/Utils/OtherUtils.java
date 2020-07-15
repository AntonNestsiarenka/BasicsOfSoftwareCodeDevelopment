package Utils;

import Exceptions.IndexOfIntValueOutOfBoundException;

import java.math.BigInteger;
import java.util.HashSet;

public class OtherUtils {

    public static double calculateRow(int n) {
        // Расчет суммы членов ряда для задания 16.
        return 1 / Math.pow(2, n) + 1 / Math.pow(3, n);
    }

    public static int sumOfSquares(int limit) {
        // Сумма квадратов чисел от 0 до limit.
        int sumOfSquares = 0;
        for (int i = 1; i <= limit; i++)
            sumOfSquares += i * i;
        return sumOfSquares;
    }

    public static BigInteger productOfSquares(int limit) {
        // Произведение квадратов чисел от 1 до limit.
        BigInteger productOfSquares = BigInteger.valueOf(1);
        for (int i = 1; i <= limit; i++)
            productOfSquares = productOfSquares.multiply(BigInteger.valueOf(i * i));
        return productOfSquares;
    }

    public static double func(double x) {
        // Функция для задачи 13.
        return (x > 2) ? x : -x;
    }

    public static double min(double x, double y) {
        // Возвращает минимальное из двух чисел.
        return (x <= y) ? x : y;
    }

    public static double max(double x, double y) {
        // Возвращает максимальное из двух чисел.
        return (x >= y) ? x : y;
    }

    public static boolean isATriangle(double angle1, double angle2)
    {
        // Возвращает истину или ложь (может ли треугольник существовать) на основании углов angle1 и angle2 в градусах.
        if (angle1 > 0 && angle2 > 0)
        {
            double angle3 = 180 - angle1 - angle2;
            return angle3 > 0 && angle3 < 180;
        }
        return false;
    }

    public static boolean isRectangularTriangle(double angle1, double angle2, double angle3)
    {
        // Определяет является ли треугольник прямоугольным.
        return angle1 == 90 || angle2 == 90 || angle3 == 90;
    }

    public static boolean isPointBelongs(double x, double y)
    {
        // Определяет принадлежит ли точка некоторой области.
        return (x >= -4 && x <= 4 && y >= -3 && y <= 0) ? true : (x >= -2 && x <= 2 && y >= 0 && y <= 4) ? true : false;
    }

    public static boolean isPointsOnLine(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        // Определяет принадлежат ли все точки одной прямой.
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return (y3 - y1) * deltaX - ((x3 - x1) * deltaY) == 0;
    }

    public static int sumOfNumbers(int limit)
    {
        // Возвращает сумму всех чисел от 0 до limit
        int sum = 0;
        for (int i = 1; i < limit; i++)
            sum += i;
        return sum;
    }

    public static double sumOfRow(double e)
    {
        // Cуммирование тех членов ряда, модуль которых больше или равен заданному е.
        double sum = 0;
        if (e > 0) {
            int i = 1;
            double sumCurrent = calculateRow(i++);
            while (Math.abs(sumCurrent) >= e) {
                sum += sumCurrent;
                sumCurrent = calculateRow(i++);
            }
        }
        return sum;
    }

    public static void printAllDivisorsOfNaturalNumbersInRange(int m, int n)
    {
        // Выводит в консоль все делители натуральных чисел в промежутке от m до n (кроме единицы и самого числа).
        for (int numb = (m >= 1) ? m : 1; numb < n; numb++) {
            System.out.printf("Число %d. Делители: ", numb);
            int rootNumb = (int) Math.sqrt(numb);
            for (int divider = 2; divider <= rootNumb; divider++) {
                if (numb % divider == 0) {
                    int secondDivider = numb / divider;
                    System.out.print(divider + ((secondDivider != divider) ? "\t" + secondDivider + "\t" : ""));
                }
            }
            System.out.println();
        }
    }

    public static boolean isIntersection(Integer number, byte digit)
    {
        // Метод определяет встречается ли цифра digit в числе number.
        int i = number;
        while (i != 0)
        {
            if (i % 10 == digit)
                return true;
            i /= 10;
        }
        return false;
    }

    public static byte countOfDigitsOfNumber(int number)
    {
        // Возвращает количество цифр в заданном числе.
        byte count = (byte) ((number != 0) ? 0 : 1);
        while (number != 0)
        {
            count++;
            number /= 10;
        }
        return count;
    }

    public static byte getDigitFromNumberByIndex(int number, byte index) throws IndexOfIntValueOutOfBoundException {
        /* Возвращает цифру из целочисленного значения по индексу. Индексация начинается с нуля. При некорректном
           индексе выкидывает исключение IndexOfIntValueOutOfBoundException. */
        byte countOfDigitsInNumber = countOfDigitsOfNumber(number);
        if (!(index >= 0 && index < countOfDigitsInNumber))
            throw new IndexOfIntValueOutOfBoundException("Index of int value out of range");
        int i = 0;
        while (i < countOfDigitsInNumber - index - 1)
        {
            number /= 10;
            i++;
        }
        return (byte) (number % 10);
    }

    public static HashSet<Byte> commonDigitsOfNumbers(int a, int b)
    {
        // Метод возвращает множество общих чисел из двух заданных чисел а и b.
        HashSet<Byte> commonDigits = new HashSet<>();
        int i = a;
        while (i != 0) {
            byte lastDigitA = (byte) (i % 10);
            int j = b;
            while (j != 0) {
                if (lastDigitA == j % 10) {
                    commonDigits.add(lastDigitA);
                    break;
                }
                j /= 10;
            }
            i /= 10;
        }
        return commonDigits;
    }
}