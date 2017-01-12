package member.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import member.model.MemberInfo;

public class MemberInfoValidator implements Validator {

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
		// //이메일 유효성 검사
		
		// 비밀번호 불일치
		passMatch: 
		if (!(memberInfo.getM_pass().equals(memberInfo.getM_pass2()))) {
			if (memberInfo.getM_pass2() == null || memberInfo.getM_pass2().trim().isEmpty()) {
				errors.rejectValue("m_pass2", "required");
				break passMatch;
			}
			errors.rejectValue("m_pass2", "passValid");
		}
		// // 비밀번호 불일치 
		
		// 비밀번호 유효성 검사
		Pattern p = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()`\"'+-./])(?=.*[0-9]).{8,16}$");
		Matcher m = p.matcher(memberInfo.getM_pass());
		passValid:
		if (!(m.find())) {
			if (memberInfo.getM_pass() == null || memberInfo.getM_pass().trim().isEmpty()) {
				errors.rejectValue("m_pass", "required");
				break passValid;
			}
			errors.rejectValue("m_pass", "passSecurity");
		}

		
	}

	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

}