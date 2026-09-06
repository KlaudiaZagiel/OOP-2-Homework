package com.nhlstenden.kingdomsandquests;

public class SpecialQuest extends Quest
{
    private Item item;

    public SpecialQuest(int difficultyLevel, int XPgain, Character character, Item item)
    {
        super(difficultyLevel, XPgain, character);
        this.item = item;
    }

    public Item getItem()
    {
        return item;
    }

}
