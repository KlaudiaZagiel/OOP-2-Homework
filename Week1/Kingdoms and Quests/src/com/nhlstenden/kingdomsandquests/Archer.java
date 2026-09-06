package com.nhlstenden.kingdomsandquests;

public class Archer extends Character
{
    public Archer(int attackDamage, int defense, int health)
    {
        super(attackDamage, defense, health);
    }

    @Override
    public void attack()
    {
        if (getHealth() <= 40)
        {
            useSpecialAbility();
        }
        else
        {
            super.attack();
        }
    }

    @Override
    public void useSpecialAbility()
    {
        System.out.println("Double damage: " + (getAttackDamage() * 2));
    }
}
