package com.nhlstenden.uservalidation;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidation implements Validation
{
    private int minAge;

    public AgeValidation(int minAge)
    {
        this.minAge = minAge;
    }

    @Override
    public boolean validateUser(User user)
    {
        int age = Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();

        if (age >= this.minAge)
        {
            return true;
        }

        return false;
    }
}
