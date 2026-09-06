package com.nhlstenden.kingdomsandquests;

public class Quest
{
    private int difficultyLevel;
    private int XPgain;
    private Character character;

    public Quest(int difficultyLevel, int XPgain, Character character)
    {
        this.difficultyLevel = difficultyLevel;
        this.XPgain = XPgain;
        this.character = character;
    }

    public int calculateRequiredXP()
    {
        return difficultyLevel * 10;
    }

    public int getDifficultyLevel()
    {
        return this.difficultyLevel;
    }

    public int getXPgain()
    {
        return XPgain;
    }

    public Character getCharacter() //access the character belonging to the quest
    {
        return character;
    }
}
