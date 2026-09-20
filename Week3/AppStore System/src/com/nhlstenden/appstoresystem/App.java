package com.nhlstenden.appstoresystem;

public class App
{
    private static final int MINIMUM_AGE_VIOLENCE = 16;
    private static final int MINIMUM_AGE_NUDITY = 18;

    private String name;
    private double price;
    private boolean containsViolence;
    private boolean containsNudity;

    public App(String name, double price, boolean containsViolence, boolean containsNudity)
    {
        this.name = name;
        this.price = price;
        this.containsViolence = containsViolence;
        this.containsNudity = containsNudity;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        if (price <= 0)
        {
            throw new IllegalArgumentException("price must be greater than 0");
        }

        this.price = price;
    }

    public boolean containsViolence()
    {
        return this.containsViolence;
    }

    public void setContainsViolence(boolean containsViolence)
    {
        this.containsViolence = containsViolence;
    }

    public boolean containsNudity()
    {
        return this.containsNudity;
    }

    public void setContainsNudity(boolean containsNudity)
    {
        this.containsNudity = containsNudity;
    }

    public boolean meetsAgeRequirement(int age)
    {
        if (this.containsNudity)
        {
            return age >= MINIMUM_AGE_NUDITY;
        }

        if (this.containsViolence)
        {
            return age >= MINIMUM_AGE_VIOLENCE;
        }

        return true;
    }
}
