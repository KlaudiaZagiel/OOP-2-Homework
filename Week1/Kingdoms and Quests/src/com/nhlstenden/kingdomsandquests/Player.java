package com.nhlstenden.kingdomsandquests;

import java.util.List;

public class Player
{
    private List<Quest> quests;
    private int xp;
    private int level;
    private String name;

    public Player(List<Quest> quests, int xp, int level, String name)
    {
        this.xp = xp;
        this.level = level;
        this.name = name;
        this.quests = quests;
    }

    public void gainXP(int amount)
    {
        xp += amount;//if player has for example 40xp and gained 30 add it to each other
    }

    public boolean canStartQuest(Quest quest)
    {
        return xp >= quest.calculateRequiredXP();
    }

    public int getLevel()
    {
        return level;
    }

    public boolean levelUp()
    {
        if (xp >= 200)
        {
            level++;
            xp -= 200;
            return true;
        }

        return false;
    }

    public List<Quest> getQuests()
    {
        return quests;
    }

    public void completeQuest(Quest quest)
    {
        if (canStartQuest(quest))
        {
            gainXP(quest.getXPgain());
        }
    }

    public int getXp()
    {
        return xp;
    }
}
