package com.company;
import Forms.Window1;
import Forms.Window2;
import Forms.Window3;
import Forms.Window4;

public class Main {

    public static void main(String[] args)
    {
        //первое окно
        Window1 win1 = new Window1();
        win1.setSize(200, 200);
        win1.setTitle("Simple program");
        win1.setVisible(true);
        //второе окно
        Window2 win2 = new Window2();
        win2.setSize(300, 150);
        win2.setTitle("Simple program");
        win2.setVisible(true);
        //третье окно
        Window3 win3 = new Window3();
        win3.setSize(300, 150);
        win3.setTitle("Simple program");
        win3.setVisible(true);
        //четвёртое окно
        Window4 win4 = new Window4();
        win4.setSize(300, 75);
        win4.setTitle("Simple program");
        win4.setVisible(true);
    }
}
