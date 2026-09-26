package com.nhlstenden.flightbooking;

public class Luggage
{
    private double weight;
    private LuggageType type;

    public Luggage(double weight, LuggageType type)
    {
        this.weight = weight;
        this.type = type;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double weight)
    {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0.");
        }

        this.weight = weight;
    }

    public LuggageType getType()
    {
        return this.type;
    }

    public void setType(LuggageType type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("type cannot be null");
        }

        this.type = this.type;
    }
}
