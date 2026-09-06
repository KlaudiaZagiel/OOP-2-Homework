package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        //Warrior
        Warrior warrior = new Warrior(30, 12, 100);

        warrior.attack();
        warrior.attack();
        warrior.attack();
        warrior.attack();
        warrior.attack();

        //Mage
        Mage mage = new Mage(30, 10, 20);

        mage.defend();

        //Archer
        Archer archer = new Archer(35, 8, 35);

        archer.attack();

        //Player
        List<Quest> quests = new ArrayList<>();
        Player player = new Player(quests, 80, 8, "Sander");


        //Normal quest
        Quest normalQuest = new Quest(3, 50, warrior);

        //Special quest
        Item manaCrystal = new Item("Mana Crystal");
        SpecialQuest specialQuest = new SpecialQuest(8, 180, mage, manaCrystal);

        //Add quests
        quests.add(normalQuest);
        quests.add(specialQuest);

        //Show available quests
        System.out.println("Available quests: ");

        for (Quest quest : player.getQuests())
        {
            System.out.println("Quest difficulty: " + quest.getDifficultyLevel());
        }

        //Test if player can start quest
        System.out.println("You can start special quest: " + player.canStartQuest(specialQuest));
        System.out.println("You can start a normal quest: " + player.canStartQuest(normalQuest));

        //Complete quest
        player.completeQuest(normalQuest); //should be special but its just for testing
        System.out.println("XP after completing quest: " + player.getXp());
        System.out.println("Reward from special quest: " + specialQuest.getItem().getTitle());


        //Lvl up
        //player.gainXP(200); i commented this bcs i wanted to check if it works by adding only xp from completing the quest

        if (player.levelUp())
        {
            System.out.println("You leveled up! This is now your level: " + player.getLevel());
            System.out.println("Remaining XP: " + player.getXp());
        }


    }
}

