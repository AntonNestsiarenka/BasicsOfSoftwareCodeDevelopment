package Utils;

import java.math.BigInteger;
import java.util.HashSet;

public class OtherUtils {

    public static double calculateRow(int n) {
        // Расчет суммы членов ряда для задания 16.
        return 1 / Math.pow(2, n) + 1 / Math.pow(3, n);
    }

    public static int sumOfSquares(int limit) {
        // Сумма квадратов чисел от 2 до limit.
        int sumOfSquares = 1;
        for (int i = 2; i <= limit; i++)
            sumOfSquares += i * i;
        return sumOfSquares;
    }

    public static BigInteger productOfSquares(int limit) {
        // Произведение квадратов чисел от 2 до limit.
        BigInteger productOfSquares = BigInteger.valueOf(1);
        for (int i = 2; i <= limit; i++)
            productOfSquares = productOfSquares.multiply(BigInteger.valueOf(i * i));
        return productOfSquares;
    }

    public static double func(double x) {
        // Функция для задачи 13.
        if (x > 2)
            return x;
        return -x;
    }

    public static double min(double x, double y) {
        // Возвращает минимальное из двух чисел.
        if (x < y)
            return x;
        return y;
    }

    public static double max(double x, double y) {
        // Возвращает максимальное из двух чисел.
        if (x > y)
            return x;
        return y;
    }

    public static boolean isATriangle(double angle1, double angle2)
    {
        // Возвращает истину или ложь (может ли треугольник существовать) на основании углов angle1 и angle2 в градусах.
        if (angle1 > 0 && angle2 > 0)
        {
            double angle3 = 180 - angle1 - angle2;
            if (angle3 > 0 && angle3 < 180)
                return true;
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
        if (x >= -4 && x <= 4 && y >= -3 && y <= 0)
            return true;
        if (x >= -2 && x <= 2 && y >= 0 && y <= 4)
            return true;
        return false;
    }

    public static boolean isPointsOnLine(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        // Определяет принадлежат ли все точки одной прямой.
        if (x1 != x2 || y1 != y2)
        {
            double deltaX = x2 - x1;
            double deltaY = y2 - y1;
            if ((y3 - y1) / deltaY == (x3 - x1) / deltaX)
                return true;
        }
        else if (x1 != x3 || y1 != y3)
            return true;
        return false;
    }

    public static int sumOfNumbers(int limit)
    {
        // Возвращает сумму всех чисел от 1 до limit
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

    public static HashSet<Integer> commonDigitsOfNumbers(int a, int b)
    {
        // Функция возвращает множество общих чисел из двух чисел.
        HashSet<Integer> common = new HashSet<>();
        int i = a;
        while (i != 0) {
            int lastDigit = i % 10;
            int j = b;
            while (j != 0) {
                //int currentDigit = j % 10;
                if (lastDigit == j % 10) {
                    common.add(lastDigit);
                    break;
                }
                j /= 10;
            }
            i /= 10;
        }
        return common;
    }
}