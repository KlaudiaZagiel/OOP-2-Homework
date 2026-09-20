package com.nhlstenden.appstoresystem;

public class EmailValidator
{
    public static boolean isValid(String email)
    {
        if (email == null || email.isBlank())
        {
            return false;
        }

        if (!email.contains("@") || !email.contains("."))
        {
            return false;
        }

        return true;
    }
}
