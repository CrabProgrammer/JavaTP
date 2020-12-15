package com.company;

public class Player extends Person
{
    public Player()
    {
        setSecretNumber(min);
    }
    public Player(String name)
    {
        setName(name);
        setSecretNumber(min);
    }
    public byte Attack(Person target, int number)
    {
        if (target.isHit(number))
            return 0;
        else
        {
            if (target.getSecretNumber() < number)
                return -1;
            else
                return 1;
        }
    }
}