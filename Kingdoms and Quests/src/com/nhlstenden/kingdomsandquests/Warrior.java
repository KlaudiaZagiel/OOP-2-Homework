package com.nhlstenden.kingdomsandquests;

public class Warrior extends Character
{
    public Warrior(int attackDamage, int defense)
    {
        super(attackDamage, defense);
    }

    @Override
    public void useSpecialAbility()  //increase attackdamage by 10 after 4 attacks
    {
        System.out.println("More damage: " + (getAttackDamage() + 15));
    }
}
