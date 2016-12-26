package member.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.model.MemberInfo;

public class MemberInfoValidator2 implements Validator {

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m_nickname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m_sex", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m_agerange", "required");

	}

	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

}