package com.example.flight_reservation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator <ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(password);
        return password.matches(".*[0-9].*") &&//poate avea oriunde la inceput/sfarsit
                password.matches("(.*[@,#,%,&,*,!].*)") &&//poate avea caracter special
                password.matches("(.*[A-Z].*)") &&
                password.matches("(.*[a-z].*)");
    }

}
