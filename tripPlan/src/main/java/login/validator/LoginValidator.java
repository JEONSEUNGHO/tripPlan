package login.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.model.MemberInfo;

public class LoginValidator implements Validator {

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m_email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m_pass", "required");

	}

	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

}