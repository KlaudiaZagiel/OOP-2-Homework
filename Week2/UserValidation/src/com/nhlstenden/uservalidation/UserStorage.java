package com.nhlstenden.uservalidation;

import java.util.ArrayList;
import java.util.List;

public class UserStorage
{
    private List<User> users;

    public UserStorage()
    {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers()
    {
        return this.users;
    }

    public void setUsers(List<User> users)
    {
        if (users == null || users.isEmpty())
        {
            throw new IllegalArgumentException("users cannot be null or empty");
        }

        for (User usersItem : users)
        {
            if (usersItem == null)
            {
                throw new IllegalArgumentException("users cannot be null");
            }
        }

        this.users = new ArrayList<>(users);
    }

    public void addUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("user cannot be null");
        }

        this.users.add(user);
    }

    public boolean usernameExists(String name)
    {
        for (User user : users)
        {
            if (user.getName().equals(name))
            {
                return true;
            }
        }

        return false;
    }
}
