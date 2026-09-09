package com.nhlstenden.uservalidation;

import java.util.ArrayList;
import java.util.List;

public class UserValidator
{
    private List<Validation> validations;
    private UserStorage userStorage;

    public UserValidator(List<Validation> validations, UserStorage userStorage)
    {
        this.validations = validations;
        this.userStorage = userStorage;

        this.validations = new ArrayList<>();
    }

    public List<Validation> getValidations()
    {
        return this.validations;
    }

    public void setValidations(List<Validation> validations)
    {
        if (validations == null || validations.isEmpty())
        {
            throw new IllegalArgumentException("validations cannot be null or empty");
        }

        for (Validation validationsItem : validations)
        {
            if (validationsItem == null)
            {
                throw new IllegalArgumentException("validations cannot be null");
            }
        }

        this.validations = new ArrayList<>(validations);
    }

    public UserStorage getUserStorage()
    {
        return this.userStorage;
    }

    public void setUserStorage(UserStorage userStorage)
    {
        if (userStorage == null)
        {
            throw new IllegalArgumentException("userStorage cannot be null");
        }

        this.userStorage = userStorage;
    }

    public boolean validateUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("user cannot be null");
        }

        for (Validation validation : this.validations)
        {
            if (!validation.validateUser(user))
            {
                return false;
            }
        }

        this.userStorage.addUser(user); //store validated user
        return true;
    }

    public void addValidation(Validation validation)
    {
        if (validation == null)
        {
            throw new IllegalArgumentException("validation cannot be null");
        }

        this.validations.add(validation);
    }
}
