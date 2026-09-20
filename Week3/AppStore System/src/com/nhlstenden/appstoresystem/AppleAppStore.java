package com.nhlstenden.appstoresystem;

public class AppleAppStore extends AppStore
{
    public AppleAppStore(Currency currency)
    {
        super(currency);
    }

    @Override
    public void uploadApp(App app)
    {
        if (app != null && app.containsNudity())
        {
            throw new IllegalArgumentException("app cannot be uploaded becasue it contains nudity");
        }

        super.uploadApp(app);
    }
}
