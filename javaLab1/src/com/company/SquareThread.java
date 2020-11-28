package com.company;

public class SquareThread extends Thread
{
    public void print(int n)
    {
        //Выводим квадрат, преобразуя результат метода pow в int (изначально double)
        System.out.println("Квадрат числа " +Integer.toString(n)+" равен "+ Integer.toString((int)Math.pow(n, 2)));
    }
}