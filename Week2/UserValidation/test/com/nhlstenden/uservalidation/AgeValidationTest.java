package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AgeValidationTest
{
    private AgeValidation ageValidation;
    private User user;

    @BeforeEach
    void setup()
    {
        this.ageValidation = new AgeValidation(18);

        this.user = new User("John", "Password1!", "john@gmail.com", LocalDate.now().minusYears(18)
        );
    }

    @Test
    void validateUser_ifAgeIsBelowMinimum_returnFalse()
    {
        this.user.setDateOfBirth(LocalDate.now().minusYears(17));

        assertFalse(this.ageValidation.validateUser(this.user));
    }

    @Test
    void validateUser_ifAgeEqualsMinimum_returnTrue()
    {
        assertTrue(this.ageValidation.validateUser(this.user));
    }

    @Test
    void validateUser_ifAgeIsAboveMinimum_returnTrue()
    {
        this.user.setDateOfBirth(LocalDate.now().minusYears(19));

        assertTrue(this.ageValidation.validateUser(this.user));
    }

    @Test
    void constructor_ifMinimumAgeIsZero_returnTrue()
    {
        AgeValidation validation = new AgeValidation(0);

        this.user.setDateOfBirth(LocalDate.now());

        assertTrue(validation.validateUser(this.user));
    }

    @Test
    void constructor_ifMinimumAgeIsNegative_throwException()
    {
        assertThrows(IllegalArgumentException.class, () -> new AgeValidation(-1));
    }
}
