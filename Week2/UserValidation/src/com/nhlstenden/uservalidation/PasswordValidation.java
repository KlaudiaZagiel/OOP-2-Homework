package com.nhlstenden.uservalidation;

public class PasswordValidation implements Validation
{
    private boolean areSpacesAllowed;
    private boolean specialCharactersRequired;
    private boolean numberRequired;
    private boolean lowercaseLetterRequired;
    private boolean upperCaseLetterRequired;

    public PasswordValidation(boolean areSpacesAllowed, boolean specialCharactersRequired, boolean numberRequired, boolean lowercaseLetterRequired, boolean upperCaseLetterRequired)
    {
        this.areSpacesAllowed = areSpacesAllowed;
        this.specialCharactersRequired = specialCharactersRequired;
        this.numberRequired = numberRequired;
        this.lowercaseLetterRequired = lowercaseLetterRequired;
        this.upperCaseLetterRequired = upperCaseLetterRequired;
    }

    @Override
    public boolean validateUser(User user)
    {
        String password = user.getPassword();

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacters = false;
        boolean hasSpace = false;

        for (char character : password.toCharArray())
        {
            if (Character.isUpperCase(character))
            {
                hasUpperCase = true;
            }

            if (Character.isLowerCase(character))
            {
                hasLowerCase = true;
            }

            if (Character.isDigit(character))
            {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(character) && !Character.isWhitespace(character))
            {
                hasSpecialCharacters = true;
            }

            if (Character.isWhitespace(character))
            {
                hasSpace = true;
            }
        }

        if (upperCaseLetterRequired && !hasUpperCase)
        {
            return false;
        }

        if (lowercaseLetterRequired && !hasLowerCase)
        {
            return false;
        }

        if (numberRequired && !hasNumber)
        {
            return false;
        }

        if (specialCharactersRequired && !hasSpecialCharacters)
        {
            return false;
        }

        if (!areSpacesAllowed && hasSpace)
        {
            return false;
        }

        return true;
    }
}


