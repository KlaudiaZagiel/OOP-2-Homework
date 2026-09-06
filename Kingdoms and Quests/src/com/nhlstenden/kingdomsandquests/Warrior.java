package com.nhlstenden.kingdomsandquests;

public class Warrior extends Character
{
    public Warrior(int attackDamage, int defense, int health)
    {
        super(attackDamage, defense, health);
    }

    @Override
    public void useSpecialAbility()  //increase attackdamage by 10 after 4 attacks
    {
        System.out.println("More damage: " + (getAttackDamage() + 15));
    }
}
