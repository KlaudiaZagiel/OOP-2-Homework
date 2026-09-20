package com.nhlstenden.appstoresystem;

import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public User(String name, String email, LocalDate dateOfBirth)
    {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if (email == null || email.isBlank())
        {
            throw new IllegalArgumentException("email cannot be null or blank");
        }

        if (EmailValidator.isValid(email))
        {
            this.email = email;
        }
        else
        {
            this.email = null;
        }

        this.email = email;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null");
        }

        if (dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("dateOfBirth cannot be in the future");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public int calculateAge()
    {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
