package gr.hua.dit.petapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation for role-based field validation
@Constraint(validatedBy = RoleBasedFieldValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleBasedField {

    String message() default "Field is required based on role";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String roleField();  // The field containing roles in the request
    String targetField();  // The field to validate (e.g., 'surname' or 'region')
    String[] validRoles();  // List of roles that require this field
}
