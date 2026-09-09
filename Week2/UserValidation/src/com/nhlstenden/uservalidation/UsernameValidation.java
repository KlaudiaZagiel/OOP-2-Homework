package com.nhlstenden.uservalidation;

public class UsernameValidation implements Validation
{
    private UserStorage userStorage;

    public UsernameValidation(UserStorage userStorage)
    {
        this.userStorage = userStorage;
    }

    @Override
    public boolean validateUser(User user)
    {
        if (this.userStorage.usernameExists(user.getName()))
        {
            return false;
        }

        return true;
    }
}
