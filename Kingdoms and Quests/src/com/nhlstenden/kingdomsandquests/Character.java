package com.nhlstenden.kingdomsandquests;

public abstract class Character
{
    private int attackDamage;
    private  int defense;

    protected Character(int attackDamage, int defense)
    {
        this.attackDamage = attackDamage;
        this.defense = defense;
    }

    public void attack()
    {
        System.out.println("attacking" + attackDamage);
    }

    public void defend() //these are not abstract methods because we assume that attack and defense works the same for every character
    {
        System.out.println("defending" + defense);
    }

    public abstract void useSpecialAbility(); //each character has different special ability so that's why it's an abstract method
}
