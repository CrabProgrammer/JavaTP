package com.company;

public class Country implements Comparable<Country>
{
    private String name = "";
    private int immigrants= 0;
    private float total = 0;
    private float national = 0;

    public Country()
    {

    }

    public Country(String newName, int newImmigrants, float newTotal, float newNational)
    {
        name = newName;
        immigrants = newImmigrants;
        total = newTotal;
        national = newNational;
    }

    public void setName(String newName)
    {
        name = name;
    }

    public void setImmigrants(int newImmigrants)
    {
        immigrants = newImmigrants;
    }

    public void setTotal(float newTotal)
    {
        total = newTotal;
    }

    public void setNational(float newNational)
    {
        national = newNational;
    }

    public String getName()
    {
        return name;
    }

    public int getImmigrants()
    {
        return immigrants;
    }

    public float getTotal()
    {
        return total;
    }

    public float getNational()
    {
        return national;
    }

    @Override
    public int compareTo(Country other)
    {
        float res = other.national - this.national;
        if (res > 0)
            return 1;
        else if(res < 0)
            return -1;
        else
            return 0;
    }
}