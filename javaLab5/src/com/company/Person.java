package com.company;

import java.util.Random;

public class Person
{
    public static final int min = 1;
    public static final int max = 20;
    public static final int dmg = 10;

    private int hp = 100;
    private String name;
    private int secretNumber ;

    protected Random rand;

    public Person()
    {
        rand = new Random();
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public String getName()
    {
        return name;
    }

    public void setHealth(int newHealth)
    {
        hp = newHealth;
    }

    public int getHealth()
    {
        return hp;
    }

    public void setSecretNumber(int newSecretNumber)
    {
        secretNumber = newSecretNumber;
    }

    public int getSecretNumber()
    {
        return secretNumber;
    }

    public boolean isHit(int number)
    {
        if (number == secretNumber)
        {
            hit();
            return true;
        }
        else
            return false;
    }

    public void hit()
    {
        hp =hp-dmg;
    }
}
