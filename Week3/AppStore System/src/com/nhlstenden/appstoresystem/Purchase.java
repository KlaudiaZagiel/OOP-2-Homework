package com.nhlstenden.appstoresystem;

public class Purchase
{
    private User user;
    private App app;

    public Purchase(User user, App app)
    {
        this.user = user;
        this.app = app;
    }

    public User getUser()
    {
        return this.user;
    }

    public void setUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("user cannot be null");
        }

        this.user = user;
    }

    public App getApp()
    {
        return this.app;
    }

    public void setApp(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("app cannot be null");
        }

        this.app = app;
    }
}
