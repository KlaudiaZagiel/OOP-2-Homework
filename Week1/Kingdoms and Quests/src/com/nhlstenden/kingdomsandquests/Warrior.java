package com.nhlstenden.kingdomsandquests;

public class Warrior extends Character
{
    private int attackCount = 0;

    public Warrior(int attackDamage, int defense, int health)
    {
        super(attackDamage, defense, health);
    }

    @Override
    public void attack()
    {
        attackCount++;

        if (attackCount == 4)
        {
            useSpecialAbility();

            attackCount = 0; //reset attack count after 4 attacks
        }
        else
        {
            super.attack();
        }
    }

    @Override
    public void useSpecialAbility()  //increase attackdamage by 15 after 4 attacks
    {
        System.out.println("More damage: " + (getAttackDamage() + 15));
    }
}
