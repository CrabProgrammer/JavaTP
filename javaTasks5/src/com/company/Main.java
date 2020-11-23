package com.company;
import java.security.MessageDigest;
import java.util.*;
import java.util.ArrayList;

public class Main {

    public static String encrypt(String str)
    {
        String result = "";
        char oldCh = str.charAt(0);
        result += (int)oldCh;
        result += " ";

        for (int i = 1; i < str.length(); i++)
        {
            char newCh = str.charAt(i);
            result += newCh - oldCh; //разница между символами
            result += " ";
            oldCh = newCh;
        }

        return result;
    }

    public static String decrypt(String str)
    {
        String result = "";
        String[] code = str.split(" ");
        int symbol = Integer.parseInt(code[0]);
        result += (char)symbol;

        for (int i = 1; i < code.length; i++)
        {
            symbol += Integer.parseInt(code[i]); //первый символ + разница
            result += (char)(symbol);
        }

        return result;
    }

    public static boolean canMove(String figure, String pos, String dest) {
        switch (figure) {
            case "пешка":
                if (pos.charAt(0) == dest.charAt(0) && //возможные варианты ходов
                        (pos.charAt(1) == dest.charAt(1) - 1 || (pos.charAt(1) == '2' && pos.charAt(1) == dest.charAt(1) - 2))) {
                    return true;
                } else {
                    return false;
                }
            case "конь":
                if ((Math.abs(pos.charAt(0) - dest.charAt(0)) == 2 && Math.abs(pos.charAt(1) - dest.charAt(1)) == 1) ||
                        (Math.abs(pos.charAt(0) - dest.charAt(0)) == 1 && Math.abs(pos.charAt(1) - dest.charAt(1)) == 2)) {
                    return true;
                } else {
                    return false;
                }
            case "ладья":
                if (pos.charAt(0) == dest.charAt(0) || pos.charAt(1) == dest.charAt(1)) {
                    return true;
                } else {
                    return false;
                }
            case "слон":
                if (Math.abs(pos.charAt(0) - pos.charAt(1)) == Math.abs(dest.charAt(0) - dest.charAt(1)))
                    return true;
                else
                    return false;

            case "ферзь":
                if ((pos.charAt(0) == dest.charAt(0) || pos.charAt(1) == dest.charAt(1)) ||
                        (Math.abs(pos.charAt(0) - pos.charAt(1)) == Math.abs(dest.charAt(0) - dest.charAt(1))))
                    return true;
                else
                    return false;

            default:
                if ((pos.charAt(0) == dest.charAt(0) && Math.abs(pos.charAt(1) - dest.charAt(1)) == 1) ||
                        (pos.charAt(1) == dest.charAt(1) && Math.abs(pos.charAt(0) - dest.charAt(0)) == 1) ||
                        (Math.abs(pos.charAt(0) - dest.charAt(0)) == 1 && Math.abs(pos.charAt(1) - dest.charAt(1)) == 1)) {
                    return true;
                } else {
                    return false;
                }
        }
    }

    public static boolean canComplete(String str, String fullStr)
    {
        int j = 0;
        for (int i = 0; i < fullStr.length(); i++)
        {
            if (j >= str.length()) //если в ходе цикла все буквы найдены и на месте
                return true;


            if (fullStr.charAt(i) == str.charAt(j)) //если символы сопадают
                j++;
        }

        if (j == str.length())
            return true;
        else
            return false;
    }

    public static int sumDigProd(ArrayList<Integer> arr)
    {
        int sum = 0;

        for (int val : arr) //суммируем все элементы
            sum += val;


        while (sum > 9) //пока результат не станет меньше 10
        {
            String sumStr = Integer.toString(sum);
            sum = 1;

            for (int i = 0; i < sumStr.length(); i++) //перемножаем цифры числа
            {
                sum *= Integer.parseInt(String.valueOf(sumStr.charAt(i)));
            }
        }

        return sum;
    }

    public static String sameVowelGroup(String str)
    {
        String[] strArr = str.split(" ");

        HashSet<Character> pattern = new HashSet<>();
        for (int i = 0; i < strArr[0].length(); i++)
        {
            char ch = strArr[0].charAt(i);
            if (ch == 'e' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'a')
            {
                if (!pattern.contains(ch)) //если такого символа не было
                {
                    pattern.add(ch); //добавляем
                }
            }
        }

        String res = strArr[0];
        for (int i = 1; i < strArr.length; i++) //перебираем слова
        {
            for (int j = 0; j < strArr[i].length(); j++)
            {
                char ch = strArr[i].charAt(j); //символ j в слове i
                if (!pattern.contains(ch) && //если гласная не совпала
                        (ch == 'e' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'a'))
                {
                    break;
                }

                if (j == strArr[i].length()-1) //если дошли до конца
                {
                    res += ' ';
                    res += strArr[i];
                }
            }
        }

        return res;
    }

    public static boolean validateCard(String str)
    {
        if (str.length() < 14 || str.length() > 19)
        {
            return false;
        }
        char checksum = str.charAt(str.length()-1);
        str = str.substring(0, str.length()-1);
        str = new StringBuilder(str).reverse().toString();
        String doubleStr = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (i % 2 == 0) //на нечётных позициях
            {
                int value = Integer.parseInt(String.valueOf(str.charAt(i)))*2;
                if (value > 9)
                {
                    value = value/10 + value%10;
                }
                doubleStr += Integer.toString(value);
            }
            else
            {
                doubleStr += str.charAt(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < doubleStr.length(); i++)
        {
            sum += Integer.parseInt(String.valueOf(doubleStr.charAt(i)));
        }

        sum = 10 - sum % 10;
        if (checksum == Integer.toString(sum).charAt(0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String numToEng(int number)
    {
        if (number == 0)
        {
            return "zero\nноль";
        }

        Stack<String> stackEn = new Stack<>();
        Stack<String> stackRu = new Stack<>();

        if (number % 100 / 10 != 1)
        {
            switch (number % 10)
            {
                case 1:
                    stackEn.push("one");
                    stackRu.push("один");
                    break;
                case 2:
                    stackEn.push("two");
                    stackRu.push("два");
                    break;
                case 3:
                    stackEn.push("three");
                    stackRu.push("три");
                    break;
                case 4:
                    stackEn.push("four");
                    stackRu.push("четыре");
                    break;
                case 5:
                    stackEn.push("five");
                    stackRu.push("пять");
                    break;
                case 6:
                    stackEn.push("six");
                    stackRu.push("шесть");
                    break;
                case 7:
                    stackEn.push("seven");
                    stackRu.push("семь");
                    break;
                case 8:
                    stackEn.push("eight");
                    stackRu.push("восемь");
                    break;
                case 9:
                    stackEn.push("nine");
                    stackRu.push("девять");
                    break;
            }
        }

        if (number > 9)
        {
            switch (number % 100 / 10)
            {
                case 1:
                    switch (number % 10)
                    {
                        case 0:
                            stackEn.push("ten");
                            stackRu.push("десять");
                            break;
                        case 1:
                            stackEn.push("eleven");
                            stackRu.push("одиннадцать");
                            break;
                        case 2:
                            stackEn.push("twelve");
                            stackRu.push("двенадцать");
                            break;
                        case 3:
                            stackEn.push("thirteen");
                            stackRu.push("тринадцать");
                            break;
                        case 4:
                            stackEn.push("fourteen");
                            stackRu.push("четырнадцать");
                            break;
                        case 5:
                            stackEn.push("fifteen");
                            stackRu.push("пятнадцать");
                            break;
                        case 6:
                            stackEn.push("sixteen");
                            stackRu.push("шестнадцать");
                            break;
                        case 7:
                            stackEn.push("seventeen");
                            stackRu.push("семнадцать");
                            break;
                        case 8:
                            stackEn.push("eighteen");
                            stackRu.push("восемнадцать");
                            break;
                        case 9:
                            stackEn.push("nineteen");
                            stackRu.push("девятнадцать");
                            break;
                    }
                    break;
                case 2:
                    stackEn.push("twenty");
                    stackRu.push("двадцать");
                    break;
                case 3:
                    stackEn.push("thirty");
                    stackRu.push("тридцать");
                    break;
                case 4:
                    stackEn.push("forty");
                    stackRu.push("сорок");
                    break;
                case 5:
                    stackEn.push("fifty");
                    stackRu.push("пятьдесят");
                    break;
                case 6:
                    stackEn.push("sixty");
                    stackRu.push("шестьдесят");
                    break;
                case 7:
                    stackEn.push("seventy");
                    stackRu.push("семьдесят");
                    break;
                case 8:
                    stackEn.push("eighty");
                    stackRu.push("восемьдесят");
                    break;
                case 9:
                    stackEn.push("ninety");
                    stackRu.push("девяносто");
                    break;
            }
        }

        if (number > 99)
        {
            switch (number / 100)
            {
                case 1:
                    stackEn.push("one hundred");
                    stackRu.push("сто");
                    break;
                case 2:
                    stackEn.push("two hundred");
                    stackRu.push("двести");
                    break;
                case 3:
                    stackEn.push("three hundred");
                    stackRu.push("триста");
                    break;
                case 4:
                    stackEn.push("four hundred");
                    stackRu.push("четыреста");
                    break;
                case 5:
                    stackEn.push("five hundred");
                    stackRu.push("пятьсот");
                    break;
                case 6:
                    stackEn.push("six hundred");
                    stackRu.push("шестьсот");
                    break;
                case 7:
                    stackEn.push("seven hundred");
                    stackRu.push("семсот");
                    break;
                case 8:
                    stackEn.push("eight hundred");
                    stackRu.push("восемсот ");
                    break;
                case 9:
                    stackEn.push("nine hundred");
                    stackRu.push("девятьсот");
                    break;
            }
        }

        String res = "";
        int end = stackEn.size();
        for (int i = 0; i < end; i++)
        {
            res += stackEn.pop();
            res += ' ';
        }
        res += '\n';

        end = stackRu.size();
        for (int i = 0; i < end; i++)
        {
            res += stackRu.pop();
            res += ' ';
        }

        return res;
    }

    public static String getSha256Hash(String str)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes("UTF-8"));// конвертирую строку в байты
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < hash.length; ++i) {
                String hex = Integer.toHexString(255 & hash[i]);//хешируем байты
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    public static String correctTitle(String str)
    {
        str = str.toLowerCase();//переводим слова в строке в строчный тип
        char[] text = str.toCharArray();//переводим строку в массив char
        String word = "";
        String result = "";

        for(int i = 0; i < text.length; ++i)
        {//перебираем массив char
            if (text[i] >= 'a' && text[i] <= 'z')
            {//если символ, это буква, то собираем слово
                word = word + text[i];
            }
            else
            {
                if (!word.equals(""))
                {   //если слово не пустое и не равно избранным словам
                    if (!word.equals("and") && !word.equals("the") && !word.equals("of") && !word.equals("in"))
                    {
                        int keyOfFirst = word.charAt(0) - 32;//то, слово начинается с заглавной буквы
                        char[] firstChar = word.toCharArray();
                        firstChar[0] = (char)keyOfFirst;
                        result = result + String.valueOf(firstChar);//добавляем слово в резульатат
                    }
                    else
                    {
                        result = result + word;
                    }
                    word = "";
                }
                result = result + text[i];
            }
        }

        return result;
    }


    public static void hexLattice(int n)
    {
        int k = 1;
        int m = 1 + 6 * (k * (k - 1) / 2); //формула
        boolean prov = false;

        for(String var4 = ""; m <= n; ++k) {
            m = 1 + 6 * (k * (k - 1) / 2);
            if (m == n) {
                prov = true;
            }
        }

        if (!prov) {
            System.out.println("Invalid");
        } else {
            System.out.println(true);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task 41
        System.out.println("Enter string:");
        String str41 = scanner.nextLine();
        if (str41.charAt(0) >= '0' && str41.charAt(0) <= '9') //если цифровая строка
            System.out.println(decrypt(str41));
        else
            System.out.println(encrypt(str41));

        //task 42
        System.out.println("Введите фигуру (пешка, конь, ладья, слон, ферзь, король), ее положение и целевую позицию. (Вы играете за белых)");
		String figure = scanner.next();
		String position = scanner.next();
		String destination = scanner.next();


		System.out.println(canMove(figure, position, destination));

        //task 43
        System.out.println("Enter test string and full string:");
		String testString = scanner.next();
		String fullString = scanner.nextLine();
		System.out.println(canComplete(testString, fullString));

        //task 44
        System.out.println("Enter array of numbers:");
		String[] strArr44 = scanner.nextLine().split(" ");
		ArrayList<Integer> arr44 = new ArrayList<>(strArr44.length);
		for (int i = 0; i < strArr44.length; i++)
		{
			arr44.add(Integer.parseInt(strArr44[i]));
		}
		System.out.println(sumDigProd(arr44));

        //task 45
        System.out.println("Enter array of words:");
		String str45 = scanner.nextLine();
		System.out.println(sameVowelGroup(str45));

        //task 46
        System.out.println("Enter card number:");
		String cardNumber = scanner.nextLine();
		System.out.println(validateCard(cardNumber));


        //task 47

        System.out.println("Enter number:");
		int number47 = Integer.parseInt(scanner.nextLine());
		System.out.println(numToEng(number47));

        //task 48
        System.out.println("Enter string:");
		String str48 = scanner.nextLine();
		System.out.println(getSha256Hash(str48));

        //task 49
        System.out.println("Enter String:");
		String title = scanner.nextLine();
		System.out.println(correctTitle(title));

        //task 50
        System.out.println("Enter number:");
        int valid = scanner.nextInt();
        hexLattice(valid);

    }
}
