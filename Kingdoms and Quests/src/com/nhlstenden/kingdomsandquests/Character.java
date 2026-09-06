package com.nhlstenden.kingdomsandquests;

public abstract class Character
{
    private int attackDamage;      //warrior, mage, archer cannot access this field directly so we need a getter
    private int defense;
    private int attackCount = 0;  //new character has 0 attacks on count
    private int defenseCount = 0;

    protected Character(int attackDamage, int defense)
    {
        this.attackDamage = attackDamage;
        this.defense = defense;
    }

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
            System.out.println("attacking" + attackDamage);
        }
    }

    public void defend() //these are not abstract methods because we assume that attack and defense works the same for every character
    {
        System.out.println("defending" + defense);
    }

    public abstract void useSpecialAbility();//each character has different special ability so that's why it's an abstract method

    protected int getAttackDamage()
    {
        return this.attackDamage;
    }

    protected int getDefense()
    {
        return this.defense;
    }

}
