package br.com.hots.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<EmailJSF, String> {

	private Pattern pattern;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public void initialize(EmailJSF a) {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public boolean isValid(String value, ConstraintValidatorContext cvc) {
		if (value == null)
			return true;
		else
			return pattern.matcher(value.toString()).matches();
	}

}