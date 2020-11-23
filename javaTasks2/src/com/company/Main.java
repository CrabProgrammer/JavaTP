package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static String repeat(String str, int number)
    {
        String resultString = "";
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            for (int j = 0; j < number; j++)
                resultString += ch;
        }

        return resultString;
    }
    public static int differenceMaxMin(ArrayList<Integer> mas)
    {
        Iterator<Integer> iter = mas.iterator();
        int max = iter.next();
        int min = max;
        while (iter.hasNext())
        {
            int val = iter.next();
            if (val > max)
                max = val;
            else if (val < min)
                min = val;
        }
        return max - min;
    }
    public static boolean isAvgWhole(ArrayList<Integer> arr)
    {
        int sum = 0;
        for (int val : arr)
            sum += val;
        if (sum % arr.size() == 0)
            return true;
        else
            return false;
    }

    public static void cumulativeSum (ArrayList<Integer> arr)
    {
        int sum = 0;
        ListIterator<Integer> it = arr.listIterator();
        while (it.hasNext())
        {
            sum += it.next();
            it.set(sum);
        }
    }
    public static int getDecimalPlaces(String str)
    {
        if (str.contains("."))
            return str.length() - 1 - str.indexOf('.');
        else
            return 0;
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
            return false;

        for (int i = 0; i < 5; i++)
        {
            if (str.codePointAt(i) < '0' || str.codePointAt(i) > '9')
                return false;
        }

        return true;
    }

    public static boolean isStrangePair(String str1, String str2)
    {
        if (str1.charAt(0) == str2.charAt(str2.length()-1) && str1.charAt(str1.length()-1) == str2.charAt(0))
            return true;
        else
            return false;
    }
    public static boolean isSuffix(String word, String str)
    {
        str = str.substring(1);
        if (word.endsWith(str))
            return true;
        else
            return false;
    }

    public static boolean isPrefix(String word, String str)
    {
        str = str.substring(0, str.length()-1);
        if (word.startsWith(str))
            return true;
        else
            return false;
    }

    public static int boxSeq(int n)
    {
        if (n % 2 == 0)
            return n;
        else
            return n+2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task 11
        System.out.println("Enter string and number:");
        String str11 = scanner.next();
        int number11 = scanner.nextInt();
        System.out.println(repeat(str11, number11));

        //task 12
        System.out.println("Enter numbers:");
        String[] strArr12 = scanner.nextLine().split(" ");
        ArrayList<Integer> arr12 = new ArrayList<>(strArr12.length);
        for (int i = 0; i < strArr12.length; i++)
        {
            arr12.add(Integer.parseInt(strArr12[i]));
        }
        System.out.println(differenceMaxMin(arr12));

        //task 13
        System.out.println("Enter array:");
        String[] strArr13 = scanner.nextLine().split(" ");
        ArrayList<Integer> arr13 = new ArrayList<>(strArr13.length);
        for (int i = 0; i < strArr13.length; i++)
        {
            arr13.add(Integer.parseInt(strArr13[i]));
        }
        System.out.println(isAvgWhole(arr13));

        //task 14
        System.out.println("Enter array of numbers:");
        String[] strArr14 = scanner.nextLine().split(" ");
        ArrayList<Integer> numArr = new ArrayList<>();
        for (int i = 0; i < strArr14.length; i++)
        {
            numArr.add(Integer.parseInt(strArr14[i]));
        }
        cumulativeSum(numArr);
        for (Integer val : numArr)
        {
            System.out.print(val.toString() + " ");
        }

        //task 15
        System.out.println("Enter number:");
        String number15 = scanner.next();
        System.out.println(getDecimalPlaces(number15));

        //task 16
        System.out.println("Enter Fibonacci number :");
        int nFib = scanner.nextInt();
        System.out.println(fibonacci(nFib));

        //task 17
        System.out.println("Enter post Index:");
        String index = scanner.nextLine();
        System.out.println(isValid(index));

        //task 18
        System.out.println("Enter 2 words:");
        String word1 = scanner.next();
        String word2 = scanner.next();

        System.out.println(isStrangePair(word1, word2));

        //task 19

        System.out.println("Enter word and prefix/suffix:");
        String word = scanner.next();
        String str = scanner.next();
        scanner.close();
        if (str.charAt(0) == '-')
            System.out.println(isSuffix(word, str));
        else
            System.out.println(isPrefix(word, str));

        //task 20
        System.out.println("Enter step number:");
        int step = scanner.nextInt();
        System.out.println(boxSeq(step));
    }
}
