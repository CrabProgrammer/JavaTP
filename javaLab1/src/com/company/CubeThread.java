package com.company;

public class CubeThread extends Thread
{
    public void print(int n)
    {
        //Выводим куб числа, преобразуя результат метода pow в int (изначально double)
            System.out.println("Куб числа " +Integer.toString(n)+" равен "+ Integer.toString(((int)Math.pow(n, 3))));
    }
}