package com.company;

public class Enemy extends Person
{
    private int chance = max-1;

    public Enemy()
    {
        generateSecretNumber();
    }

    public Enemy(String name)
    {
        setName(name);
        generateSecretNumber();
    }

    public boolean attack(Person target)
    {
        int number = rand.nextInt(chance) + min;
        if (target.isHit(number))
        {
            chance = max-1;
            return true;
        }
        else
        {
            chance--;
            return false;
        }
    }

    public void generateSecretNumber()
    {
        setSecretNumber(rand.nextInt(max-1)+min);
    }

    @Override
    public void hit()
    {
        setHealth(getHealth() - dmg);
        generateSecretNumber();
    }
}