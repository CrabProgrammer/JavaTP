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

        char cBegin = str.charAt(0);
        char cEnd = str.charAt(str.length()-1);
        if (cBegin == cEnd)
        {
            return "Two's a pair.";
        }
        return cEnd + str.substring(1, str.length()-1) + cBegin;
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

    public static boolean isKaprekar(int n)
    {
        String nn = Integer.toString(n*n);
        String str = "";
        if (nn.length() == 1)
        {
            str += "0";
        }
        str += nn;
        int end = str.length()/2;
        int n1 = Integer.parseInt(str.substring(0, end));
        int n2 = Integer.parseInt(str.substring(end, str.length()));

        if (n1 + n2 == n)
            return true;
        else
            return false;
    }

    public static String longestZero(String str)
    {
        String[] strArr = str.split("1");

        String res = "";
        for (String val : strArr)
        {
            if (val.length() > res.length())
            {
                res = val;
            }
        }

        return res;
    }

    public static int nextPrime(int n)
    {
        if (n == 2)
          return n;

        if (n % 2 == 0)
          n++;

        while (true)
        {
            int end = (int)Math.ceil(Math.sqrt(n));
            int i;
            for (i = 2; i <= end; i++)
            {
                if (n % i == 0)
                 break;

            }

            if (i == end+1)
                break;
            else
                n += 2;
        }

        return n;
    }

    public static boolean rightTriangle(ArrayList<Integer> mas)
    {
        Collections.sort(mas);
        int a = mas.get(0);
        int b = mas.get(1);
        int c = mas.get(2);

        if (a*a + b*b == c*c)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //task 21
        /*
        System.out.println("Введите значения a, b и c:");
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		in.close();
		System.out.println(solutions(a, b, c)); */


        //task 22
        /*
        System.out.println("Введите строку:");
		String str = in.nextLine();
		in.close();
		System.out.println(findZip(str)); */

        //task 23
        /*
       System.out.println("Введите число:");
		int num = in.nextInt();

		in.close();

		System.out.println(checkPerfect(num)); */

        //task 24
        /*
        System.out.println("Введите строку:");
		String str = in.nextLine();
		in.close();
		System.out.println(flipEndChars(str));
         */

        //task 25
        /*
        System.out.println("Введите шестнадцатеричный код:");
		String str = in.nextLine();
		in.close();
		System.out.println(isValidHexCode(str));
		*/

        //task 26
        /*
        System.out.println("Введите два массива:");
		String[] strArr = in.nextLine().split(" ");
		ArrayList<Integer> mas1 = new ArrayList<>(strArr.length);
		for (int i = 0; i < strArr.length; i++)
		{
			mas1.add(Integer.parseInt(strArr[i]));
		}
		strArr = in.nextLine().split(" ");
		ArrayList<Integer> mas2 = new ArrayList<>(strArr.length);
		for (int i = 0; i < strArr.length; i++)
		{
			mas2.add(Integer.parseInt(strArr[i]));
		}
		in.close();
		System.out.println(same(mas1, mas2));
		*/

        //task 27
        /*
        System.out.println("Введите число:");
		int n = in.nextInt();
		in.close();
		System.out.println(isKaprekar(n));*/

        //task 28
        /*
        System.out.println("Введите двоичное число:");
		String str = in.next();
		in.close();
		System.out.println(longestZero(str)); */

        //task 29
        /*
        System.out.println("Введите число:");
		int n = in.nextInt();
		in.close();
		System.out.println(nextPrime(n));*/

        //task 20
        System.out.println("Введите стороны треугольника:");
        ArrayList<Integer> mas = new ArrayList<>(3);
        mas.add(in.nextInt());
        mas.add(in.nextInt());
        mas.add(in.nextInt());
        in.close();
        System.out.println(rightTriangle(mas));
    }
}
