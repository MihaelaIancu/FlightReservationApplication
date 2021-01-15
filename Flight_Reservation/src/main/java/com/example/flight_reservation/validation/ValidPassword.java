package com.example.flight_reservation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})//peste ce field-uri se aplica
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {PasswordValidator.class}//avem o clasa care sa valideze, sa contina criteriile de validare
)
@Size(min = 8, max = 20)

public @interface ValidPassword {
    String message() default "The password is invalid. It should contains at least 1 digit, 1 upper case letter, one lower case letter and one special character.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
