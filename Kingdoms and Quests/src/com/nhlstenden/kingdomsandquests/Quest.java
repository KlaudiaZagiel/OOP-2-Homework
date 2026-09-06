package com.nhlstenden.kingdomsandquests;

public abstract class Quest
{
    private int difficultyLevel;
    private int XPgain;

    protected Quest(int difficultyLevel, int XPgain)
    {
        this.difficultyLevel = difficultyLevel;
        this.XPgain = XPgain;
    }

    public int calculateRequiredXP()
    {
        return difficultyLevel * 10;
    }
}
