package com.company;
import java.util.Scanner;

public class Main {
    public static int remainder(int a, int b)
    {
        return a % b;
    }

    public static double triArea(double a, double b)
    {
        return a * b / 2;
    }

    public static int animals(int a, int b, int c) {
        return 2 * a + 4 * (b + c);
    }

    public static boolean profitableGamble(double prob, double prize, double pay)
    {
            return (prob * prize > pay);
    }

    public static String operation(int N, int a, int b)
    {
        if (N == a + b)
            return "added";
        else if (N == a - b)
            return "substracted";
        else if (N == a * b)
            return "multiplied";
        else if (N == a / b)
            return "divided";
        else return "None";
    }

    public static int ctoa(String a)
    {
        char ans = a.charAt(0);
        return (int) ans;
    }

    public static int addUpTo(int n) {
        int a = 0;
        for (int i = 1; i <= n; i++)
            a = a + i;
        return a;
    }

    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }

    public static double sumOfCubes(int[] cubes) {
        double sum = 0;
        for (int i = 0; i < cubes.length; i++) {
            System.out.println(cubes[i]);
            sum += Math.pow(cubes[i], 3);
        }
        return sum;
    }

    public static boolean abcmath(int a, int b, int c){
        int result = a;
        for (int i = 0; i < b; i++) {
            result += result;
        }
        if (result % c == 0)
            return true;
        else return false;
    }


    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        //task 1
        /*System.out.println("Enter numbers a and b");

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(remainder(a, b));*/

        //task 2
        /*System.out.println("Enter h and w of triangle");

        double a = scanner.nextInt();
        double b = scanner.nextInt();

        double ans = triArea(a, b);
        System.out.println(ans);*/

        //task 3
        /*System.out.println("Enter count of chicks, cows and pigs");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int ans = animals(a, b, c);
        System.out.println(ans);*/

        //task 4

        /*System.out.println("Enter prob, prize and pay");

        double prob = scanner.nextDouble();
        double prize = scanner.nextDouble();
        double pay = scanner.nextDouble();

        System.out.println(profitableGamble(prob, prize, pay));*/

        //task 5

        /*System.out.println("Enter numbers N, a, b");

        int N = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(operation(N, a, b));*/

        //task 6

        /*System.out.println("Enter symbol");

        String a = scanner.nextLine();

        System.out.println(ctoa(a));*/

        //task 7

        /*System.out.println("Enter last number from array");

        int n = scanner.nextInt();

        System.out.println(addUpTo(n));*/

        //task 8

        /*System.out.println("Enter two sides of triangle");

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(nextEdge(a, b));*/

        //task 9

        /*System.out.println("Enter array size");
        int size = scanner.nextInt();
        int cubes[] = new int[size];
        System.out.println("Enter number for array.");
        for (int i = 0; i < size; i++) {
            cubes[i] = scanner.nextInt();
        }

        System.out.print((int)sumOfCubes(cubes));*/

        //task 10

        System.out.println("Enter a, b and c");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(abcmath(a, b, c));
       }
}
