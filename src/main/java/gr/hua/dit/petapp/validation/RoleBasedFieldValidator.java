package gr.hua.dit.petapp.validation;

import gr.hua.dit.petapp.payload.request.SignupRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class RoleBasedFieldValidator implements ConstraintValidator<RoleBasedField, Object> {

    private String roleField;
    private String targetField;
    private String[] validRoles;

    @Override
    public void initialize(RoleBasedField constraintAnnotation) {
        this.roleField = constraintAnnotation.roleField();
        this.targetField = constraintAnnotation.targetField();
        this.validRoles = constraintAnnotation.validRoles();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        SignupRequest request = (SignupRequest) value;
        Set<String> roles = request.getRole();

        if (roles == null || roles.isEmpty()) {
            return true; // No role means no validation needed
        }

        for (String role : roles) {
            for (String validRole : validRoles) {
                if (role.equals(validRole)) {
                    if ("surname".equals(targetField)) {
                        return request.getSurname() != null && !request.getSurname().isEmpty();
                    } else if ("region".equals(targetField)) {
                        return request.getRegion() != null && !request.getRegion().isEmpty();
                    }
                }
            }
        }
        return true;
    }
}
