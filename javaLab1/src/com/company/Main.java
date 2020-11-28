package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        CubeThread cubeThread = new CubeThread();
        SquareThread squareThread = new SquareThread();
        cubeThread.start();
        squareThread.start();

        while (true)
        {
            int a = random.nextInt(300);
            System.out.println("Сгенерированное число: " + Integer.toString(a));
            if (a % 2 == 1)
                cubeThread.print(a);
            else
                squareThread.print(a);
            Thread.sleep(2000);
        }
    }
}


