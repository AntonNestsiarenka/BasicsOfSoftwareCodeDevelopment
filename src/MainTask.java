import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;

import static Utils.InputUtils.*;
import static Utils.OtherUtils.*;

public class MainTask {

    public static void task1() {
        // Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
        double a = inputDouble("Введите действительное значение аргумента a: ");
        double b = inputDouble("Введите действительное значение аргумента b: ");
        double c = inputDouble("Введите действительное значение аргумента c: ");
        double z = ((a - 3) * b / 2) + c;
        System.out.printf("Результат функции: z = %f\n", z);
    }

    public static void task2() {
        // Вычислить значение выражения по формуле (все переменные принимают действительные значения).
        double a = inputDouble("Введите действительное значение a: ");
        double b = inputDouble("Введите действительное значение b: ");
        double c = inputDouble("Введите действительное значение c: ");
        double x = (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
        System.out.printf("Результат выражения: %f\n", x);
    }

    public static void task3() {
        //  Вычислить значение выражения по формуле (все переменные принимают действительные значения).
        double x = inputDouble("Введите действительное значение x: ");
        double y = inputDouble("Введите действительное значение y: ");
        double result = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
        System.out.printf("Результат выражения: %f\n", result);
    }

    public static void task4() {
        /* Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
           дробную и целую части числа и вывести полученное значение числа. */
        double r = inputDouble("Введите действительное значение r в формате nnn.ddd: ");
        int intPart = (int) r;
        int fractionalPart = (int) (Math.round((r - intPart) * 1000.0));
        double newNumber = fractionalPart * 1.0 + (double) intPart / 1000;
        System.out.printf("Первоначальное число %6.3f%n\nПреобразованное число %6.3f%n", r, newNumber);
    }

    public static void task5() {
        /* Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
           данное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc. */
        int time = inputNaturalNumber("Введите любое время в сек: ");
        int ss = time % 60;
        int mm = (time / 60) % 60;
        int hh = time / 3600;
        System.out.printf("%dч %dмин %dс\n", hh, mm, ss);
    }

    public static void task6() {
        /* Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
           принадлежит закрашенной области, и false — в противном случае. */
        double x = inputDouble("Введите действительное значение координаты x: ");
        double y = inputDouble("Введите действительное значение координаты y: ");
        System.out.println(isPointBelongs(x, y));
    }

    public static void task7()
    {
        /* Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
           он прямоугольным. */
        double angle1 = inputDouble("Введите действительное значение угла1 треугольника: ");
        double angle2 = inputDouble("Введите действительное значение угла2 треугольника: ");
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
        double a = inputDouble("Введите действительное значение a: ");
        double b = inputDouble("Введите действительное значение b: ");
        double c = inputDouble("Введите действительное значение c: ");
        double d = inputDouble("Введите действительное значение d: ");
        double result = max(min(a, b), min(c, d));
        System.out.println("Результат выражения: " + result);
    }

    public static void task9() {
        // Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
        System.out.println("Введите координаты трех точек.");
        double x1 = inputDouble("Введите действительное значение координаты x1: ");
        double y1 = inputDouble("Введите действительное значение координаты y1: ");
        double x2 = inputDouble("Введите действительное значение координаты x2: ");
        double y2 = inputDouble("Введите действительное значение координаты y2: ");
        double x3 = inputDouble("Введите действительное значение координаты x3: ");
        double y3 = inputDouble("Введите действительное значение координаты y3: ");
        if (isPointsOnLine(x1, y1, x2, y2, x3, y3))
            System.out.println("Все точки расположены на одной прямой");
        else
            System.out.println("Все точки расположены не на одной прямой");
    }

    public static void task10() {
        /* Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
           отверстие. */
        System.out.println("Введите размеры A и B прямоугольного отверстия.");
        double sizeA = inputDouble("Введите действительное значение размера A: ");
        double sizeB = inputDouble("Введите действительное значение размера B: ");
        System.out.println("Введите размеры x, y, z кирпича.");
        double sizeX = inputDouble("Введите действительное значение размера x: ");
        double sizeY = inputDouble("Введите действительное значение размера y: ");
        double sizeZ = inputDouble("Введите действительное значение размера z: ");
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
        double x = inputDouble("Введите действительное значение аргумента x: ");
        double f = 1 / (Math.pow(x, 3) + 6);
        if (x <= 3) {
            f = x * x - 3 * x + 9;
        }
        System.out.println("Результат выполнения функции: " + f);
    }

    public static void task12() {
        /* Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
           все числа от 1 до введенного пользователем числа. */
        int limit = inputUInt("Введите целое положительное число: ");
        int sum = sumOfNumbers(limit);
        System.out.printf("Сумма всех чисел от 1 до %d = %d\n", limit, sum);
    }

    public static void task13() {
        // Вычислить значения функции на отрезке [а,b] c шагом h.
        double lowLimit = inputDouble("Введите нижнюю границу диапазона значений аргумента функции: ");
        double highLimit = inputDouble("Введите верхнюю границу диапазона значений аргумента функции: ");
        double step = inputDouble("Введите шаг, с которым будет меняться значение аргумента функции: ");
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
        double e = inputDouble("Введите действительное число: ");
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
        int m = inputNaturalNumber("Введите натуральное число m: ");
        int n = inputNaturalNumber("Введите натуральное число n: ");
        System.out.println("Все делители чисел от m до n.");
        for (int numb = m; numb < n; numb++) {
            System.out.printf("Число %d. Делители: ", numb);
            int rootNumb = (int) Math.sqrt(numb);
            for (int divider = 2; divider <= rootNumb; divider++) {
                if (numb % divider == 0)
                    System.out.print(divider + "\t" + numb / divider + "\t");
            }
            System.out.println();
        }
    }

    public static void task19() {
        // Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
        int a = inputUInt("Введите целое положительное число A: ");
        int b = inputUInt("Введите целое положительное число B: ");
        HashSet<Integer> common = commonDigitsOfNumbers(a, b);
        Iterator<Integer> iter = common.iterator();
        System.out.print("Цифры, входящие в запись как первого так и второго числа: ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean logic = true;
        while (logic) {
            int choice = inputUInt("Введите номер 1 - 19 задачи для запуска решения или 0 для завершения процедуры выбора: ");
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