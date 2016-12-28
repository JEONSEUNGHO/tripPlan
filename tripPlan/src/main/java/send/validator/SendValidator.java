package send.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import send.dao.SendDataBean;

public class SendValidator implements Validator {
	public void validate(Object target, Errors errors) {
 
		SendDataBean send = (SendDataBean) target;
		
		if (send.getSm_receiver() == null || send.getSm_receiver().trim().isEmpty()) {
			errors.rejectValue("sm_receiver", "receiver");

		}
		
		if (send.getSm_title() == null || send.getSm_title().trim().isEmpty()) {
			errors.rejectValue("sm_title", "title");

		}

		if (send.getSm_contents() == null || send.getSm_contents().trim().isEmpty()) {
			errors.rejectValue("sm_contents", "contents");

		}

	}

	public boolean supports(Class<?> clazz) {
		return SendDataBean.class.isAssignableFrom(clazz);
	}

}
