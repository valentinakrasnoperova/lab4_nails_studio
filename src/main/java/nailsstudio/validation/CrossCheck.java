package nailsstudio.validation;

import nailsstudio.validation.enumeration.Condition;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CrossCheckValidator.class)
public @interface CrossCheck {

    String field1();
    String field2();
    Condition condition();
    String message() default "Condition failed";


    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}