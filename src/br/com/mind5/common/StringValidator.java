package br.com.mind5.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.mind5.model.checker.ModelCheckerOption;

public final class StringValidator {
	static private final boolean SUCCESS = ModelCheckerOption.SUCCESS;
	static private final boolean FAILED = ModelCheckerOption.FAILED;
	
	static private final String REGEX_EMAIL           		= "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";	
	static private final String REGEX_PERSON_NAME           = "[A-Z]*[a-zA-z ']*";
	static private final String REGEX_UNSAFE_STRING_WWW     = "^(?!.*(?:w\\s*w\\s*w)).*$";
	static private final String REGEX_UNSAFE_STRING_FTP     = "^(?!.*(?:f\\s*t\\s*p)).*$";
	static private final String REGEX_UNSAFE_STRING_HTTP    = "^(?!.*(?:h\\s*t\\s*t\\s*p)).*$";
	static private final String REGEX_UNSAFE_STRING_COM     = "^(?!.*(?:\\.\\s*c\\s*o\\s*m)).*$";
	static private final String REGEX_UNSAFE_STRING_GENERAL = "^(?!.*(?:[<>@])).*$";
	
	
	static public boolean validatePersonName(String name) {
		if (name == null)
			return false;
		
	    return validate(name, REGEX_PERSON_NAME);		
	}
	
	
	
	static public boolean validateEmail(String name) {
		if (name == null)
			return false;
		
	    return validate(name, REGEX_EMAIL);		
	}
	
	
	
	static public boolean validateSafe(String name) {
		if (name == null)
			return false;
		
	    if (validate(name, REGEX_UNSAFE_STRING_GENERAL) == FAILED)
	    	return FAILED;
	    
	    if (validate(name, REGEX_UNSAFE_STRING_WWW) == FAILED)
	    	return FAILED;
	    
	    if (validate(name, REGEX_UNSAFE_STRING_FTP) == FAILED)
	    	return FAILED;
	    
	    if (validate(name, REGEX_UNSAFE_STRING_HTTP) == FAILED)
	    	return FAILED;
	    
	    if (validate(name, REGEX_UNSAFE_STRING_COM) == FAILED)
	    	return FAILED;
	    
	    return SUCCESS;
	}
	
	
	
	static private boolean validate(String str, String regexExpression) {
		Pattern regex = Pattern.compile(regexExpression);
	    Matcher matcher = regex.matcher(str);
	    
	    return matcher.matches();		
	}
}
