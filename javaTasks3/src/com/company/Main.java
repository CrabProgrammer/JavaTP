package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Main {

    public static int solutions(int a, int b, int c)
    {
        double d = b*b - 4*a*c;
        if (d < 0)
            return 0;
        else if (d == 0)
            return 1;
        else
            return 2;
    }

    public static int findZip(String str)
    {
        return str.indexOf("zip", str.indexOf("zip")+3);
    }
    public static boolean checkPerfect(int num)
    {
        int sum = 1;
        int n = (int)Math.ceil(Math.sqrt(num));

        for (int i = 2; i < n; i++)
        {
            if (num % i == 0)
            {
                n = num / i;
                sum += i;
                sum += n;

                if (sum > num)
                    return false;
            }
        }

        if (sum != num)
            return false;
        else
            return true;
    }

    public static String flipEndChars(String str)
    {
        if (str.length() < 2)
        {
            return "Incompatible.";
        }

        char charBegin = str.charAt(0);
        char charEnd = str.charAt(str.length()-1);
        if (charBegin == charEnd)
        {
            return "Two's a pair.";
        }
        return charEnd + str.substring(1, str.length()-1) + charBegin;
    }

    public static boolean isValidHexCode(String str)
    {
        if (str.length() != 7 || str.charAt(0) != '#')
            return false;

        for (int i = 1; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F') && (ch < 'a' || ch > 'f'))
                return false;
        }

        return true;
    }

    public static boolean same(ArrayList<Integer> mas1, ArrayList<Integer> mas2)
    {
        if ((new HashSet<Integer>(mas1)).size() == (new HashSet<>(mas2)).size())
            return true;
        else
            return false;
    }

    public static boolean isKaprekar(int number)
    {
        String square = Integer.toString(number*number);
        String str = "";
        if (square.length() == 1)
        {
            str += "0";
        }
        str += square;
        int end = str.length()/2;
        int n1 = Integer.parseInt(str.substring(0, end));
        int n2 = Integer.parseInt(str.substring(end, str.length()));

        if (n1 + n2 == number)
            return true;
        else
            return false;
    }

    public static String longestZero(String str)
    {
        String[] strArr = str.split("1");

        String result = "";
        for (String val : strArr)
            if (val.length() > result.length())
                result = val;

        return result;
    }

    public static int nextPrime(int number)
    {
        if (number == 2)
          return number;

        if (number % 2 == 0)
          number++;

        while (true)
        {
            int endNumber = (int)Math.ceil(Math.sqrt(number));
            int i;
            for (i = 2; i <= endNumber; i++)
                if (number % i == 0)
                 break;

            if (i - 1 == endNumber)
                break;
            else
                number += 2;
        }
        return number;
    }

    public static boolean rightTriangle(ArrayList<Integer> arr)
    {
        Collections.sort(arr);
        int a = arr.get(0);
        int b = arr.get(1);
        int c = arr.get(2);

        if (a*a + b*b == c*c)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task 21
        System.out.println("Enter numbers a, b and c:");
		int a21 = scanner.nextInt();
		int b21 = scanner.nextInt();
		int c21 = scanner.nextInt();
		System.out.println(solutions(a21, b21, c21));

        //task 22
        System.out.println("Enter string:");
		String str23 = scanner.nextLine();
		System.out.println(findZip(str23));

        //task 23
        System.out.println("Enter number:");
		int num23 = scanner.nextInt();
		System.out.println(checkPerfect(num23));

        //task 24
        System.out.println("Enter string:");
		String str24 = scanner.nextLine();
		System.out.println(flipEndChars(str24));

        //task 25
        System.out.println("Enter 16bit code:");
		String bit16Code = scanner.nextLine();
		System.out.println(isValidHexCode(bit16Code));

        //task 26
        System.out.println("Enter two arrays:");
		String[] strArr26 = scanner.nextLine().split(" ");
		ArrayList<Integer> firstArray = new ArrayList<>(strArr26.length);
		for (int i = 0; i < strArr26.length; i++)
		{
			firstArray.add(Integer.parseInt(strArr26[i]));
		}
		strArr26 = scanner.nextLine().split(" ");
		ArrayList<Integer> secondArray = new ArrayList<>(strArr26.length);
		for (int i = 0; i < strArr26.length; i++)
		{
			secondArray.add(Integer.parseInt(strArr26[i]));
		}
		System.out.println(same(firstArray, secondArray));

        //task 27
        System.out.println("Enter number:");
		int number27 = scanner.nextInt();
		System.out.println(isKaprekar(number27));

        //task 28
        System.out.println("Enter double number:");
		String str28 = scanner.next();
		System.out.println(longestZero(str28));

        //task 29
        System.out.println("Enter number:");
		int number29 = scanner.nextInt();
		System.out.println(nextPrime(number29));

        //task 30
        System.out.println("Enter triangle sides:");
        ArrayList<Integer> triangleSides = new ArrayList<>(3);
        triangleSides.add(scanner.nextInt());
        triangleSides.add(scanner.nextInt());
        triangleSides.add(scanner.nextInt());
        System.out.println(rightTriangle(triangleSides));
    }
}
