package member.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import member.model.MemberInfo;

@Controller
public class FindpwValidator implements Validator {

	public void validate(Object target, Errors errors) {
		
		MemberInfo memberInfo = (MemberInfo) target;
		
		// 이메일 유효성 검사
		Pattern p1 = Pattern.compile("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}");
		Matcher m1 = p1.matcher(memberInfo.getM_email());
		email:
		if (!(m1.find())) {
			if (memberInfo.getM_email() == null || memberInfo.getM_email().trim().isEmpty()) {
				errors.rejectValue("m_email", "required");
				break email;
			}
			errors.rejectValue("m_email", "emailHost");
		}
	}

	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

}