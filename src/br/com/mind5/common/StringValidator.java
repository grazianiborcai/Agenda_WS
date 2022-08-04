package br.com.mind5.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringValidator {
	static private final String REGEX_PERSON_NAME = "[A-Z]*[a-zA-z ']*";
	
	
	static public boolean validatePersonName(String name) {
		if (name == null)
			return false;
		
	    return validate(name, REGEX_PERSON_NAME);		
	}
	
	
	
	static private boolean validate(String str, String regexExpression) {
		Pattern regex = Pattern.compile(regexExpression);
	    Matcher matcher = regex.matcher(str);
	    
	    return matcher.matches();		
	}
}
