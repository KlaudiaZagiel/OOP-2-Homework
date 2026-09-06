package com.nhlstenden.kingdomsandquests;

public class Mage extends Character
{
    public Mage(int attackDamage, int defense, int health)
    {
        super(attackDamage, defense, health);
    }


    @Override
    public void defend()
    {
        if (getHealth() <= 40)
        {
            useSpecialAbility();
        }
        else
        {
            super.defend();
        }
    }

    @Override
    public void useSpecialAbility()
    {
        System.out.println("Increased defense: " + (getDefense() + 25));
    }
}
