package com.nhlstenden.kingdomsandquests;

public class Main
{
    public static void main(String[] args)
    {
        Warrior warrior = new Warrior(30, 12, 100);

        warrior.attack();
        warrior.attack();
        warrior.attack();
        warrior.attack();
        warrior.attack();

        Mage mage = new Mage(30, 10, 20);

        mage.defend();

        Archer archer = new Archer(35, 8, 35);

        archer.attack();
    }
}
