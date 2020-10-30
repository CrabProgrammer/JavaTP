package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static String repeat(String str, int n)
    {
        String res = "";
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            for (int j = 0; j < n; j++)
            {
                res += ch;
            }
        }

        return res;
    }
    public static int differenceMaxMin(ArrayList<Integer> mas)
    {
        Iterator<Integer> it = mas.iterator();
        int max = it.next();
        int min = max;
        while (it.hasNext())
        {
            int val = it.next();
            if (val > max)
            {
                max = val;
            }
            else if (val < min)
            {
                min = val;
            }
        }

        return max - min;
    }
    public static boolean isAvgWhole(ArrayList<Integer> mas)
    {
        int sum = 0;
        for (int val : mas)
        {
            sum += val;
        }

        if (sum % mas.size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void cumulativeSum (ArrayList<Integer> mas)
    {
        int sum = 0;
        ListIterator<Integer> it = mas.listIterator();
        while (it.hasNext())
        {
            sum += it.next();
            it.set(sum);
        }
    }
    public static int getDecimalPlaces(String str)
    {
        if (str.contains("."))
        {
            return str.length() - 1 - str.indexOf('.');
        }
        else
        {
            return 0;
        }
    }

    public static int fibonacci(int n)
    {
        switch (n)
        {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                int a = 1;
                int b = 2;
                int res;
                for (int i = 3; i < n; i++)
                {
                    res = a + b;
                    a = b;
                    b = res;
                }
                return a + b;
        }
    }

    public static boolean isValid(String str)
    {
        if (str.length() != 5)
        {
            return false;
        }

        for (int i = 0; i < 5; i++)
        {
            if (str.codePointAt(i) < '0' || str.codePointAt(i) > '9')
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isStrangePair(String str1, String str2)
    {
        if (str1.charAt(0) == str2.charAt(str2.length()-1) && str1.charAt(str1.length()-1) == str2.charAt(0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean isSuffix(String word, String str)
    {
        str = str.substring(1);
        if (word.endsWith(str))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isPrefix(String word, String str)
    {
        str = str.substring(0, str.length()-1);
        if (word.startsWith(str))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int boxSeq(int n)
    {
        if (n % 2 == 0)
        {
            return n;
        }
        else
        {
            return n+2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //task 11
        /*
        System.out.println("Введите строку и число:");
        String str = in.next();
        int n = in.nextInt();
        in.close();
        System.out.println(repeat(str, n)); */

        //task 12
        /*
        System.out.println("Введите числа:");
        String[] strArr = in.nextLine().split(" ");
        ArrayList<Integer> mas = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++)
        {
            mas.add(Integer.parseInt(strArr[i]));
        }
        in.close();
        System.out.println(differenceMaxMin(mas)); */

        //task 13
        /*
        System.out.println("Введите массив:");
        String[] strArr = in.nextLine().split(" ");
        ArrayList<Integer> mas = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++)
        {
            mas.add(Integer.parseInt(strArr[i]));
        }
        in.close();
        System.out.println(isAvgWhole(mas)); */

        //task 14
        /*System.out.println("Введите массив чисел:");
        String[] strArr = in.nextLine().split(" ");
        ArrayList<Integer> mas = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++)
        {
            mas.add(Integer.parseInt(strArr[i]));
        }
        in.close();
        cumulativeSum(mas);
        for (Integer val : mas)
        {
            System.out.print(val.toString() + " ");
        }      */

        //task 15
        /*
        System.out.println("Введите число:");
        String str = in.next();
        in.close();
        System.out.println(getDecimalPlaces(str));*/

        //task 16
        /*
        System.out.println("Введите номер числа Фибоначчи:");
        int n = in.nextInt();
        in.close();
        System.out.println(fibonacci(n)); */

        //task 17
        /*
        System.out.println("Введите почтовый индекс:");
        String str = in.nextLine();
        in.close();
        System.out.println(isValid(str));*/

        //task 18
        /*
        System.out.println("Введите два слова:");
        String str1 = in.next();
        String str2 = in.next();
        in.close();
        System.out.println(isStrangePair(str1, str2)); */

        //task 19
        /*
        System.out.println("Введите слово и префикс/суффикс:");
        String word = in.next();
        String str = in.next();
        in.close();
        if (str.charAt(0) == '-')
        {
            System.out.println(isSuffix(word, str));
        }
        else
        {
            System.out.println(isPrefix(word, str));
        }*/

        //task 20
        System.out.println("Введите номер шага:");
        int n = in.nextInt();
        in.close();
        System.out.println(boxSeq(n));
    }
}
