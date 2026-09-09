package com.nhlstenden.uservalidation;

public class EmailValidation implements Validation
{
    public EmailValidation()
    {
    }

    @Override
    public boolean validateUser(User user)
    {
        //email must contain @ and .

        String email = user.getEmail();

        if (email.contains("@") && email.contains("."))
        {
            return true;
        }

        return false;
    }
}
