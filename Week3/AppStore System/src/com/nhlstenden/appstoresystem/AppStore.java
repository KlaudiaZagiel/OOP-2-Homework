package com.nhlstenden.appstoresystem;

import java.util.ArrayList;
import java.util.List;

public abstract class AppStore
{
    private static final double DEVELOPER_REVENUE_SHARE = 0.30;
    private Currency currency;
    private List<App> apps;
    private List<Purchase> purchases;

    protected AppStore(Currency currency)
    {
        this.currency = currency;
        this.apps = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public Currency getCurrency()
    {
        return this.currency;
    }

    public void setCurrency(Currency currency)
    {
        if (currency == null)
        {
            throw new IllegalArgumentException("currency cannot be null");
        }

        this.currency = currency;
    }

    public List<App> getApps()
    {
        return this.apps;
    }

    public void setApps(List<App> apps)
    {
        if (apps == null)
        {
            throw new IllegalArgumentException("apps cannot be null");
        }

        for (App appsItem : apps)
        {
            if (appsItem == null)
            {
                throw new IllegalArgumentException("apps cannot be null");
            }
        }

        this.apps = new ArrayList<>(apps);
    }

    public List<Purchase> getPurchases()
    {
        return this.purchases;
    }

    public void setPurchases(List<Purchase> purchases)
    {
        if (purchases == null)
        {
            throw new IllegalArgumentException("purchases cannot be null");
        }

        for (Purchase purchasesItem : purchases)
        {
            if (purchasesItem == null)
            {
                throw new IllegalArgumentException("purchases cannot be null");
            }
        }

        this.purchases = new ArrayList<>(purchases);
    }

    public void uploadApp(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("app cannot be null");
        }

        this.apps.add(app);
    }

    public void purchaseApp(User user, App app)
    {
        if (app == null || user == null)
        {
            throw new IllegalArgumentException("app or user cannot be null");
        }

        int age = user.calculateAge();

        if (!app.meetsAgeRequirement(age))
        {
            throw new DownloadNotAllowedException("user does not meet the age requirement");
        }

        Purchase purchase = new Purchase(user, app);
        this.purchases.add(purchase);
    }

    public double calculateTotalRevenue()
    {
        double totalRevenue = 0;

        for (Purchase purchase : this.purchases)
        {
            double appPrice = purchase.getApp().getPrice();
            double developerShare = appPrice * DEVELOPER_REVENUE_SHARE;
            double storeRevenue = appPrice - developerShare;

            totalRevenue = totalRevenue + storeRevenue;
        }

        return totalRevenue;
    }

    public double calculateRevenue(App app)
    {
        double totalRevenue = 0;

        for (Purchase purchase : this.purchases)
        {
            if (purchase.getApp() == app)
            {
                double appPrice = purchase.getApp().getPrice();
                double developerShare = appPrice * DEVELOPER_REVENUE_SHARE;
                double storeRevenue = appPrice - developerShare;

                totalRevenue = totalRevenue + storeRevenue;
            }
        }

        return totalRevenue;
    }
}
