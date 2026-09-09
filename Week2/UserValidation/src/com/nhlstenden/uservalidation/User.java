package com.nhlstenden.uservalidation;

import java.time.LocalDate;

public class User
{
    private String name;
    private String password;
    private LocalDate dateOfBirth;

    public User(String name, String password, LocalDate dateOfBirth)
    {
        this.name = name;
        this.password = password;
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

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        if (password == null || password.isBlank())
        {
            throw new IllegalArgumentException("password cannot be null or blank");
        }

        this.password = password;
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

        this.dateOfBirth = dateOfBirth;
    }
}
