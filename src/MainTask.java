import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.lang.Math.*;

public class MainTask {
    static public int inputUInt(String str) {
        // Функция для ввода целочисленного положительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUInt(str);
    }

    static public double inputDouble(String str) {
        // Функция для ввода действительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();
        return number;
    }

    static public int inputNaturalNumber(String str) {
        // Функция для ввода натурального числа из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (number > 0)
            return number;
        System.out.println("Число должно быть > 0.");
        return inputNaturalNumber(str);
    }

    static public double calculateRow(int n) {
        // Расчет суммы членов ряда для задания 16.
        return 1 / Math.pow(2, n) + 1 / Math.pow(3, n);
    }

    static public int sumOfSquares(int limit) {
        // Сумма квадратов чисел от 2 до limit.
        int sumOfSquares = 1;
        for (int i = 2; i <= limit; i++)
            sumOfSquares += i * i;
        return sumOfSquares;
    }

    static public BigInteger productOfSquares(int limit) {
        // Произведение квадратов чисел от 2 до limit.
        BigInteger productOfSquares = BigInteger.valueOf(1);
        for (int i = 2; i <= limit; i++)
            productOfSquares = productOfSquares.multiply(BigInteger.valueOf(i * i));
        return productOfSquares;
    }

    static public double func(double x) {
        // Функция для задачи 13.
        if (x > 2)
            return x;
        return -x;
    }

    static public double min(double x, double y) {
        // Функция возвращает минимальное из двух чисел.
        if (x < y)
            return x;
        return y;
    }

    static public double max(double x, double y) {
        // Функция возвращает максимальное из двух чисел.
        if (x > y)
            return x;
        return y;
    }

    static public void task1() {
        // Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
        double a = inputDouble("Введите действительное значение аргумента a: ");
        double b = inputDouble("Введите действительное значение аргумента b: ");
        double c = inputDouble("Введите действительное значение аргумента c: ");
        double z = ((a - 3) * b / 2) + c;
        System.out.printf("Результат функции: z = %f\n", z);
    }

    static public void task2() {
        // Вычислить значение выражения по формуле (все переменные принимают действительные значения).
        double a = inputDouble("Введите действительное значение a: ");
        double b = inputDouble("Введите действительное значение b: ");
        double c = inputDouble("Введите действительное значение c: ");
        double x = (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
        System.out.printf("Результат выражения: %f\n", x);
    }

    static public void task3() {
        //  Вычислить значение выражения по формуле (все переменные принимают действительные значения).
        double x = inputDouble("Введите действительное значение x: ");
        double y = inputDouble("Введите действительное значение y: ");
        double result = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
        System.out.printf("Результат выражения: %f\n", result);
    }

    static public void task4() {
        // Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
        // дробную и целую части числа и вывести полученное значение числа.
        double r = inputDouble("Введите действительное значение r в формате nnn.ddd: ");
        int intPart = (int) r;
        int fractionalPart = (int) (Math.round((r - intPart) * 1000.0));
        double newNumber = fractionalPart * 1.0 + (double) intPart / 1000;
        System.out.printf("Первоначальное число %6.3f%n\nПреобразованное число %6.3f%n", r, newNumber);
    }

    static public void task5() {
        // Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
        // данное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc.
        int time = inputNaturalNumber("Введите любое время в сек: ");
        int ss = time % 60;
        int mm = (time / 60) % 60;
        int hh = time / 3600;
        System.out.printf("%dч %dмин %dс\n", hh, mm, ss);
    }

    static public void task6() {
        // Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
        // принадлежит закрашенной области, и false — в противном случае:
        double x = inputDouble("Введите действительное значение координаты x: ");
        double y = inputDouble("Введите действительное значение координаты y: ");
        boolean isPointBelongs = false;
        if (x >= -4 && x <= 4 && y >= -3 && y <= 0)
            isPointBelongs = true;
        else if (x >= -2 && x <= 2 && y >= 0 && y <= 4)
            isPointBelongs = true;
        System.out.println(isPointBelongs);
    }

    static public void task7() {
        // Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
        // он прямоугольным.
        double angle1 = inputDouble("Введите действительное значение угла1 треугольника: ");
        double angle2 = inputDouble("Введите действительное значение угла2 треугольника: ");
        if (angle1 <= 0 || angle2 <= 0)
            System.out.println("Треугольник не существует.");
        else {
            double angle3 = 180 - angle1 - angle2;
            if (angle3 > 0 && angle3 < 180) {
                System.out.println("Треугольник существует.");
                if (angle1 == 90 || angle2 == 90 || angle3 == 90)
                    System.out.println("Он является прямоугольным.");
            } else
                System.out.println("Треугольник не существует.");
        }
    }

    static public void task8() {
        // Найти max{min(a, b), min(c, d)}.
        double a = inputDouble("Введите действительное значение a: ");
        double b = inputDouble("Введите действительное значение b: ");
        double c = inputDouble("Введите действительное значение c: ");
        double d = inputDouble("Введите действительное значение d: ");
        double result = MainTask.max(MainTask.min(a, b), MainTask.min(c, d));
        System.out.println("Результат выражения: " + result);
    }

    static public void task9() {
        // Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
        System.out.println("Введите координаты трех точек.");
        double x1 = inputDouble("Введите действительное значение координаты x1: ");
        double y1 = inputDouble("Введите действительное значение координаты y1: ");
        double x2 = inputDouble("Введите действительное значение координаты x2: ");
        double y2 = inputDouble("Введите действительное значение координаты y2: ");
        double x3 = inputDouble("Введите действительное значение координаты x3: ");
        double y3 = inputDouble("Введите действительное значение координаты y3: ");
        if (x1 != x2 || y1 != y2) {
            double deltaX = x2 - x1;
            double deltaY = y2 - y1;
            if ((y3 - y1) / deltaY == (x3 - x1) / deltaX) {
                System.out.println("Все точки расположены на одной прямой.");
            } else
                System.out.println("Точка с координатами (" + x3 + ", " + y3 + ") находится не на одной прямой");
        } else if (x1 != x3 || y1 != y3)
            System.out.println("Все точки расположены на одной прямой.");
        else
            System.out.println("Все точки имеют одинаковые координаты. Прямой быть не может");
    }

    static public void task10() {
        // Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
        // отверстие.
        System.out.println("Введите размеры A и B прямоугольного отверстия.");
        double a = inputDouble("Введите действительное значение размера A: ");
        double b = inputDouble("Введите действительное значение размера B: ");
        System.out.println("Введите размеры x, y, z кирпича.");
        double x = inputDouble("Введите действительное значение размера x: ");
        double y = inputDouble("Введите действительное значение размера y: ");
        double z = inputDouble("Введите действительное значение размера z: ");
        boolean isPut = false;
        if ((x < a && y < b) || (x < b && y < a))
            isPut = true;
        else if ((y < a && z < b) || (y < b && z < a))
            isPut = true;
        else if ((x < a && z < b) || (x < b && z < a))
            isPut = true;
        System.out.println(isPut);
    }

    static public void task11() {
        //  Вычислить значение функции.
        double x = inputDouble("Введите действительное значение аргумента x: ");
        double f = 1 / (Math.pow(x, 3) + 6);
        if (x <= 3) {
            f = x * x - 3 * x + 9;
        }
        System.out.println("Результат выполнения функции: " + f);
    }

    static public void task12() {
        // Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
        // все числа от 1 до введенного пользователем числа.
        int limit = inputUInt("Введите целое положительное число: ");
        int sum = 0;
        for (int i = 1; i < limit; i++)
            sum += i;
        System.out.printf("Сумма всех чисел от 1 до %d = %d\n", limit, sum);
    }

    static public void task13() {
        // Вычислить значения функции на отрезке [а,b] c шагом h:
        double lowLimit = MainTask.inputDouble("Введите нижнюю границу диапазона значений аргумента функции: ");
        double highLimit = MainTask.inputDouble("Введите верхнюю границу диапазона значений аргумента функции: ");
        double step = MainTask.inputDouble("Введите шаг, с которым будет меняться значение аргумента функции: ");
        for (double i = lowLimit; i <= highLimit; i += step)
            System.out.printf("Аргумент функции x = %f | Значение функции f(x) = %f\n", i, func(i));
    }

    static public void task14() {
        // Найти сумму квадратов первых ста чисел.
        int sum = sumOfSquares(100);
        System.out.printf("Cумма квадратов первых ста чисел = %d\n", sum);
    }

    static public void task15() {
        // Составить программу нахождения произведения квадратов первых двухсот чисел.
        BigInteger product = productOfSquares(200);
        System.out.printf("Произведение квадратов первых двухсот чисел = %d\n", product);
    }

    static public void task16() {
        // Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
        // заданному е.
        double e = inputDouble("Введите действительное число: ");
        double sum = 0;
        int i = 1;
        double sumCurrent = calculateRow(i++);
        while (Math.abs(sumCurrent) >= e) {
            sum += sumCurrent;
            sumCurrent = calculateRow(i++);
        }
        System.out.printf("Сумма членов ряда, модуль которых больше заданного числа = %f\n", sum);
    }

    static public void task17() {
        // Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
        for (char ch = 33; ch <= 126; ch++)
            System.out.printf("Код символа = %d | Символ: %c\n", (int) ch, ch);
    }

    static public void task18() {
        // Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
        // m и n вводятся с клавиатуры.
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

    static public void task19() {
        // Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
        int a = inputUInt("Введите целое положительное число A: ");
        int b = inputUInt("Введите целое положительное число B: ");
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
        Iterator<Integer> iter = common.iterator();
        System.out.print("Цифры, входящие в запись как первого так и второго числа: ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean logic = true;
        while(logic)
        {
            System.out.print("Введите номер 1 - 19 задачи для запуска решения или 0 для завершения процедуры выбора: ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
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