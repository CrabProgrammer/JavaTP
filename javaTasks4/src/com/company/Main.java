package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
public class Main {

    public static String essay(int k, ArrayList<String> strArr)
    {
        String res = "";
        int count = k;
        Iterator<String> iter = strArr.iterator(); //навигация по элементам

        String val = iter.next();
        res += val + " "; //добавляем первое слово и отнимаем длинну
        count -= val.length();
        while (iter.hasNext()) //добавляем в строку , если хватает места
        {
            val = iter.next();
            if (count < val.length())
            {
                res += '\n';
                count = k;
            }
            res += val + " ";
            count -= val.length();
        }

        return res;
    }

    public static String split(String str)
    {
        String res = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            res += ch;
            //если открылось и закрылось после этого одинаковое количество скобок то ставим пробел
            if (ch == '(')
            {
                count++;
            }
            else
            {
                count--;
            }

            if (count == 0)
            {
                res += ' ';
            }
        }

        return res;
    }


    public static String toCamelCase(String str)
    {
        String res = "";
        boolean newWord = false;

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == '_') //определяем новое слово по прочерку
            {
                newWord = true;
            }
            else if (newWord)
            {
                newWord = false;
                res += (char)(ch-32); //Начинаем с большого символа
            }
            else
            {
                res += ch;
            }
        }

        return res;
    }
    public static String toSnakeCase(String str)
    {
        String result = "";

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') //определяем по большому символу, ставим прочерк и делаем маленьким
            {
                result += '_';
                result += (char)(ch+32);
            }
            else
            {
                result += ch;
            }
        }

        return result;
    }



    public static String overTime(double start, double finish, double rate, double mult)
    {
        double reg = 0;
        double over = 0;
        int dStart = 9;
        int dFinish = 17;
        if (start < dStart && finish < dStart) //если день начался и закончился раньше РД
        {
            over = finish - start;
        }
        else if (start < dStart && finish >= dStart && finish <= dFinish) //Если начался раньше но закончился норм
        {
            over = dStart - start;
            reg = finish - dStart;
        }
        else if (start < dStart && finish > dFinish) //начался раньше и закончился позже
        {
            over = dStart - start + finish - dFinish;
            reg = dStart + dFinish;
        }
        else if (start >= dStart && start <= dFinish && finish >= dStart && finish <= dFinish) //начался и закончился норм
        {
            reg = finish - start;
        }
        else if (start >= dStart && start <= dFinish && finish > dFinish) //начался норм, но закончился позже
        {
            reg = dFinish - start;
            over = finish - dFinish;
        }
        else //начался и закончился позже
        {
            over = finish - start;
        }

        return "$" + String.format("%.2f", reg*rate + over*rate*mult);
    }
    public static String BMI(double w, double h)
    {
        double val = w / (h*h);
        String res = String.format("%.1f", val);
        if (val < 18.5)
        {
            res += " Underweight";
        }
        else if (val >= 18.5 && val < 25)
        {
            res += " Normal weight";
        }
        else
        {
            res += " Overweight";
        }

        return res;
    }
    public static int bugger(int n)
    {
        int count = 0;
        String str = Integer.toString(n);

        while (str.length() > 1)
        {
            count++;

            int val = 1;
            for (int i = 0; i < str.length(); i++)
            {
                val *= Integer.parseInt((str.substring(i, i+1))); //перемножаем все между собой
            }

            str = Integer.toString(val);
        }

        return count;
    }

    public static String toStarShorthand(String str)
    {
        String res = "";
        int count = 1;
        char ch = '\0';

        for (int i = 0; i < str.length(); i++)
        {
            char newCh = str.charAt(i);

            if (newCh == ch)
            {
                count++;
            }
            else
            {
                if (count != 1) //если больше одного раза встретился символ
                {
                    res += '*';
                    res += Integer.toString(count);
                    count = 1;
                }
                res += newCh;
                ch = newCh;
            }
        }
        if (count != 1)
        {
            res += '*';
            res += Integer.toString(count);
        }

        return res;
    }

    public static boolean doesRhyme(String str1, String str2)
    {
        int index;

        index = str1.lastIndexOf(' ');
        if (index == -1)
        {
            index = 0;
        }
        String word1 = str1.substring(index+1).toUpperCase();

        index = str2.lastIndexOf(' ');
        if (index == -1)
        {
            index = 0;
        }
        String word2 = str2.substring(index+1).toUpperCase();

        String check = "";
        for (int i = 0; i < word1.length(); i++)
        {
            char ch = word1.charAt(i);
            //если гласная
            if (ch == 'E' || ch == 'Y' || ch == 'U' || ch == 'O' || ch == 'A' || ch == 'I')
            {
                check += ch;
            }
        }

        int count = 0;
        for (int i = 0; i < word2.length(); i++)
        {
            char ch = word2.charAt(i);
            //если во втором слове больше или они не совпадают
            if (ch == 'E' || ch == 'Y' || ch == 'U' || ch == 'O' || ch == 'A' || ch == 'I')
            {
                if (count >= check.length())
                {
                    return false;
                }
                else if (ch != check.charAt(count))
                {
                    return false;
                }
                count++;
            }
        }

        return true;
    }

    public static boolean trouble(int a, int b)
    {
        String str1 = Integer.toString(a);
        String str2 = Integer.toString(b);
        char number = '\0';
        int count = 0;

        for (int i = 0; i < str1.length(); i++)
        {
            char ch = str1.charAt(i);
            if (ch == number)
            {
                count++;
            }
            else
            {
                number = ch;
                count = 0;
            }
            if (count == 2) //если повторилось 3 раза
            {
                //если содержит это число два раза
                if (str2.contains(String.copyValueOf(new char[]{number, number})))
                {
                    return true;
                }
                else
                {
                    count = 0;
                }
            }
        }

        return false;
    }

    public static int countUniqueBooks(String str, String endChar)
    {
        int count = 0;
        boolean open = false;
        HashSet<Character> set = new HashSet<>(); //создаём хэш таблицу

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (!open && ch == endChar.charAt(0))
            {
                open = true;
            }
            else if (open)
            {
                if (ch != endChar.charAt(0))
                {
                    if (!set.contains(ch)) //если в таблице нет такого симовла, добавляем и добавляем кол ун книг
                    {
                        set.add(ch);
                        count++;
                    }
                }
                else
                {
                    open = false;
                    set.clear();
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task 31
        System.out.println("Enter count of words and string size:");
		int countOfWords = scanner.nextInt();
		int stringSize = scanner.nextInt();

		ArrayList<String> strArr = new ArrayList<>(countOfWords);
		System.out.println("Enter text:");
		for (int i = 0; i < countOfWords; i++)
		{
			strArr.add(scanner.next());
		}
		System.out.println(essay(stringSize, strArr));

        //task 32
        System.out.println("Enter string:");
		String str32 = scanner.next();
		System.out.println(split(str32));

        //task 33
        System.out.println("Enter string:");
		String str33 = scanner.next();
		if (str33.indexOf('_') != -1) //если в строке есть нижние подчёркивания
		{
			System.out.println(toCamelCase(str33));
		}
		else
		{
			System.out.println(toSnakeCase(str33));
		}

        //task 34

        System.out.println("Enter start,finish, rate and multiply:");
		double start = scanner.nextDouble();
		double finish = scanner.nextDouble();
		double rate = scanner.nextDouble();
		double mult = scanner.nextDouble();
		System.out.println(overTime(start, finish, rate, mult));

        //task 35
        System.out.println("Enter h and w:");
		double h = scanner.nextDouble();
		double w = scanner.nextDouble();
		System.out.println(BMI(h, w));

        //task 36
        System.out.println("Enter number:");
		int number36 = scanner.nextInt();
		System.out.println(bugger(number36));

        //task 37
        System.out.println("Enter string:");
		String str37 = scanner.nextLine();
		System.out.println(toStarShorthand(str37));

        //task 38
        System.out.println("Enter two strings:");
		String strP1 = scanner.nextLine();
		String strP2 = scanner.nextLine();
		System.out.println(doesRhyme(strP1, strP2));

        //task 39
        System.out.println("Enter two numbers:");
		int first = scanner.nextInt();
		int second = scanner.nextInt();
		System.out.println(trouble(first, second));

        //task 40
        System.out.println("Enter string and begin/end symbol of book:");
        String str40 = scanner.next();
        String endChar = scanner.next();
        System.out.println(countUniqueBooks(str40, endChar));
    }
}
