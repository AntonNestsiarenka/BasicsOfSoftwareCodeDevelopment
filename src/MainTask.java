import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import static Utils.InputUtils.*;
import static Utils.OtherUtils.*;

public class MainTask {

    public static void task1() {
        // Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
        Scanner scanner = new Scanner(System.in);
        double a = inputDouble("Введите действительное значение аргумента a: ", scanner);
        double b = inputDouble("Введите действительное значение аргумента b: ", scanner);
        double c = inputDouble("Введите действительное значение аргумента c: ", scanner);
        double z = ((a - 3) * b / 2) + c;
        System.out.printf("Результат функции: z = %f\n", z);
    }

    public static void task2() {
        // Вычислить значение выражения по формуле (все переменные принимают действительные значения).
        Scanner scanner = new Scanner(System.in);
        double a = inputDouble("Введите действительное значение a: ", scanner);
        double b = inputDouble("Введите действительное значение b: ", scanner);
        double c = inputDouble("Введите действительное значение c: ", scanner);
        double x = (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
        System.out.printf("Результат выражения: %f\n", x);
    }

    public static void task3() {
        //  Вычислить значение выражения по формуле (все переменные принимают действительные значения).
        Scanner scanner = new Scanner(System.in);
        double x = inputDouble("Введите действительное значение x: ", scanner);
        double y = inputDouble("Введите действительное значение y: ", scanner);
        double result = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
        System.out.printf("Результат выражения: %f\n", result);
    }

    public static void task4() {
        /* Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
           дробную и целую части числа и вывести полученное значение числа. */
        Scanner scanner = new Scanner(System.in);
        double r = inputDouble("Введите действительное значение r в формате nnn.ddd: ", scanner);
        int intPart = (int) r;
        int fractionalPart = (int) (Math.round((r - intPart) * 1000));
        double newNumber = fractionalPart + (double) intPart / 1000;
        System.out.printf("Первоначальное число %6.3f%n\nПреобразованное число %6.3f%n", r, newNumber);
    }

    public static void task5() {
        /* Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
           данное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc. */
        Scanner scanner = new Scanner(System.in);
        int time = inputNaturalNumber("Введите любое время в сек: ", scanner);
        int ss = time % 60;
        int mm = (time / 60) % 60;
        int hh = time / 3600;
        System.out.printf("%dч %dмин %dс\n", hh, mm, ss);
    }

    public static void task6() {
        /* Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
           принадлежит закрашенной области, и false — в противном случае. */
        Scanner scanner = new Scanner(System.in);
        double x = inputDouble("Введите действительное значение координаты x: ", scanner);
        double y = inputDouble("Введите действительное значение координаты y: ", scanner);
        System.out.println(isPointBelongs(x, y));
    }

    public static void task7()
    {
        /* Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
           он прямоугольным. */
        Scanner scanner = new Scanner(System.in);
        double angle1 = inputDouble("Введите действительное значение угла1 треугольника: ", scanner);
        double angle2 = inputDouble("Введите действительное значение угла2 треугольника: ", scanner);
        if (isATriangle(angle1, angle2))
        {
            System.out.println("Треугольник существует.");
            if (isRectangularTriangle(angle1, angle2, 180 - angle1 - angle2))
                System.out.println("Он является прямоугольным");
        }
        else
            System.out.println("Треугольник не существует.");
    }

    public static void task8() {
        // Найти max{min(a, b), min(c, d)}.
        Scanner scanner = new Scanner(System.in);
        double a = inputDouble("Введите действительное значение a: ", scanner);
        double b = inputDouble("Введите действительное значение b: ", scanner);
        double c = inputDouble("Введите действительное значение c: ", scanner);
        double d = inputDouble("Введите действительное значение d: ", scanner);
        double result = max(min(a, b), min(c, d));
        System.out.println("Результат выражения: " + result);
    }

    public static void task9() {
        // Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты трех точек.");
        double x1 = inputDouble("Введите действительное значение координаты x1: ", scanner);
        double y1 = inputDouble("Введите действительное значение координаты y1: ", scanner);
        double x2 = inputDouble("Введите действительное значение координаты x2: ", scanner);
        double y2 = inputDouble("Введите действительное значение координаты y2: ", scanner);
        double x3 = inputDouble("Введите действительное значение координаты x3: ", scanner);
        double y3 = inputDouble("Введите действительное значение координаты y3: ", scanner);
        if (isPointsOnLine(x1, y1, x2, y2, x3, y3))
            System.out.println("Все точки расположены на одной прямой");
        else
            System.out.println("Все точки расположены не на одной прямой");
    }

    public static void task10() {
        /* Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
           отверстие. */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размеры A и B прямоугольного отверстия.");
        double sizeA = inputDouble("Введите действительное значение размера A: ", scanner);
        double sizeB = inputDouble("Введите действительное значение размера B: ", scanner);
        System.out.println("Введите размеры x, y, z кирпича.");
        double sizeX = inputDouble("Введите действительное значение размера x: ", scanner);
        double sizeY = inputDouble("Введите действительное значение размера y: ", scanner);
        double sizeZ = inputDouble("Введите действительное значение размера z: ", scanner);
        boolean isPass = false;
        if ((sizeX < sizeA && sizeY < sizeB) || (sizeX < sizeB && sizeY < sizeA))
            isPass = true;
        else if ((sizeY < sizeA && sizeZ < sizeB) || (sizeY < sizeB && sizeZ < sizeA))
            isPass = true;
        else if ((sizeX < sizeA && sizeZ < sizeB) || (sizeX < sizeB && sizeZ < sizeA))
            isPass = true;
        System.out.println(isPass);
    }

    public static void task11() {
        //  Вычислить значение функции.
        Scanner scanner = new Scanner(System.in);
        double x = inputDouble("Введите действительное значение аргумента x: ", scanner);
        double f = (x <= 3) ? x * x - 3 * x + 9 : 1 / (Math.pow(x, 3) + 6);
        System.out.println("Результат выполнения функции: " + f);
    }

    public static void task12() {
        /* Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
           все числа от 1 до введенного пользователем числа. */
        Scanner scanner = new Scanner(System.in);
        int limit = inputUInt("Введите целое положительное число: ", scanner);
        int sum = sumOfNumbers(limit);
        System.out.printf("Сумма всех чисел от 0 до %d = %d\n", limit, sum);
    }

    public static void task13() {
        // Вычислить значения функции на отрезке [а,b] c шагом h.
        Scanner scanner = new Scanner(System.in);
        double lowLimit = inputDouble("Введите нижнюю границу диапазона значений аргумента функции: ", scanner);
        double highLimit = inputDouble("Введите верхнюю границу диапазона значений аргумента функции: ", scanner);
        double step = inputDouble("Введите шаг, с которым будет меняться значение аргумента функции: ", scanner);
        if (step > 0) {
            for (double i = lowLimit; i <= highLimit; i += step)
                System.out.printf("Аргумент функции x = %f | Значение функции f(x) = %f\n", i, func(i));
        }
    }

    public static void task14() {
        // Найти сумму квадратов первых ста чисел.
        int sum = sumOfSquares(100);
        System.out.printf("Cумма квадратов первых ста чисел = %d\n", sum);
    }

    public static void task15() {
        // Составить программу нахождения произведения квадратов первых двухсот чисел.
        BigInteger product = productOfSquares(200);
        System.out.printf("Произведение квадратов первых двухсот чисел = %d\n", product);
    }

    public static void task16() {
        /* Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
           заданному е. */
        Scanner scanner = new Scanner(System.in);
        double e = inputDouble("Введите действительное число: ", scanner);
        double sum = sumOfRow(e);
        System.out.printf("Сумма членов ряда, модуль которых больше заданного числа = %f\n", sum);
    }

    public static void task17() {
        // Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
        for (char ch = 33; ch <= 126; ch++)
            System.out.printf("Код символа = %d | Символ: %c\n", (int) ch, ch);
    }

    public static void task18() {
        /* Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
           m и n вводятся с клавиатуры. */
        Scanner scanner = new Scanner(System.in);
        int m = inputNaturalNumber("Введите натуральное число m: ", scanner);
        int n = inputNaturalNumber("Введите натуральное число n: ", scanner);
        System.out.println("Все делители натуральных чисел в промежутке от m до n.");
        printAllDivisorsOfNaturalNumbersInRange(m, n);
    }

    public static void task19() {
        // Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
        Scanner scanner = new Scanner(System.in);
        int a = inputUInt("Введите целое положительное число A: ", scanner);
        int b = inputUInt("Введите целое положительное число B: ", scanner);
        HashSet<Byte> commonDigits = commonDigitsOfNumbers(a, b);
        System.out.print("Цифры, входящие в запись как первого так и второго числа: ");
        Iterator<Byte> iterator = commonDigits.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean logic = true;
        while (logic) {
            int choice = inputUInt("Введите номер 1 - 19 задачи для запуска решения или 0 для завершения процедуры выбора: ", scanner);
            switch (choice) {
                case 0: {
                    logic = false;
                    break;
                }
                case 1: {
                    task1();
                    break;
                }
                case 2: {
                    task2();
                    break;
                }
                case 3: {
                    task3();
                    break;
                }
                case 4: {
                    task4();
                    break;
                }
                case 5: {
                    task5();
                    break;
                }
                case 6: {
                    task6();
                    break;
                }
                case 7: {
                    task7();
                    break;
                }
                case 8: {
                    task8();
                    break;
                }
                case 9: {
                    task9();
                    break;
                }
                case 10: {
                    task10();
                    break;
                }
                case 11: {
                    task11();
                    break;
                }
                case 12: {
                    task12();
                    break;
                }
                case 13: {
                    task13();
                    break;
                }
                case 14: {
                    task14();
                    break;
                }
                case 15: {
                    task15();
                    break;
                }
                case 16: {
                    task16();
                    break;
                }
                case 17: {
                    task17();
                    break;
                }
                case 18: {
                    task18();
                    break;
                }
                case 19: {
                    task19();
                    break;
                }
                default:
                    System.out.println("Такого задания не существует. Попробуйте еще раз или завершите процедуру выбора.");
            }
        }
    }
}