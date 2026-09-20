package com.nhlstenden.appstoresystem;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        // Create app stores
        AppleAppStore appleStore = new AppleAppStore(Currency.EURO);
        GooglePlayStore googleStore = new GooglePlayStore(Currency.EURO);

        // Create apps
        App minecraft = new App("Minecraft", 7.99, true, false);
        App spotify = new App("Spotify", 9.99, false, false);
        App adultApp = new App("Adult App", 14.99, false, true);

        // Create users
        User user1 = new User("John", "john@gmail.com", LocalDate.of(2000, 5, 10));

        User user2 = new User("Tim", "tim@gmail.com", LocalDate.of(2012, 3, 20));

        // Upload apps
        appleStore.uploadApp(minecraft);
        appleStore.uploadApp(spotify);

        googleStore.uploadApp(minecraft);
        googleStore.uploadApp(spotify);
        googleStore.uploadApp(adultApp);

        // Purchase apps
        appleStore.purchaseApp(user1, minecraft);
        appleStore.purchaseApp(user1, spotify);

        googleStore.purchaseApp(user1, minecraft);


        System.out.println("Apple Store apps:");
        for (App app : appleStore.getApps())
        {
            System.out.println(app.getName());
        }

        System.out.println();

        System.out.println("Apple Store revenue: €" + appleStore.calculateTotalRevenue());

        System.out.println("Minecraft revenue: €" + appleStore.calculateRevenue(minecraft));

        // Test age restriction
        try
        {
            googleStore.purchaseApp(user2, minecraft);
        }
        catch (DownloadNotAllowedException exception)
        {
            System.out.println(exception.getMessage());
        }

        // Test Apple nudity restriction
        try
        {
            appleStore.uploadApp(adultApp);
        }
        catch (IllegalArgumentException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}