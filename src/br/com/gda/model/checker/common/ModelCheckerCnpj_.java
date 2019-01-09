package br.com.gda.model.checker.common;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class ModelCheckerCnpj_ extends ModelCheckerTemplateSimple<String> {

	public ModelCheckerCnpj_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(String cnpj, Connection conn, String schemaName) {	
		if (cnpj == null)
			return SUCCESS;
		
		if (checkOnlyNumber(cnpj) == FAILED)			
			return FAILED;
		
		if (checkLength(cnpj) == FAILED)			
			return FAILED;
		
		if (checkSequence(cnpj) == FAILED)			
			return FAILED;
		
		if (checkNumberVerification(cnpj) == FAILED)
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkOnlyNumber(String cnpj) {
	    return cnpj.matches("^\\d+$");
	}
	
	
	
	private boolean checkLength(String cnpj) {
	    if (cnpj.length() != 14)
	           return FAILED;
	    
	    return SUCCESS;
	}
	
	
	
	private boolean checkSequence(String cnpj) {
		boolean IS_MONODIGIT = true;
		
		if (cnpj.matches("^(\\d)\\1+$") == IS_MONODIGIT) 
			return FAILED;		

	    
	    return SUCCESS;
	}
	
	
	
	private boolean checkNumberVerification(String cnpj) {
	    char dig13 = getNumberDig13(cnpj);
	    char dig14 = getNumberDig14(cnpj);
	    
	    if (cnpj.charAt(12) == dig13 && cnpj.charAt(13) == dig14)
	    	return SUCCESS;
	    
	    return FAILED;
	}
	
	
	
	private char getNumberDig13(String cnpj) {
		final int CNPJ_BODY = 11;
		final int ASCII_ZERO = 48;
		
		int bodyProduct = 0;
	    int weight = 2;
	  
	    for (int i=CNPJ_BODY; i>=0; i--) {       
	      int eachNumber = (int)(cnpj.charAt(i) - ASCII_ZERO); 
	      bodyProduct = bodyProduct + (eachNumber * weight);
	      weight = weight + 1;
	      
	      if (weight == 10)
	    	  weight = 2;
	    }
	    
	    
	    int bodyRatio = bodyProduct % 11;
	    char finalResult = '0';
	      
	    if ((bodyRatio != 0) && (bodyRatio != 1)) 
	   	  finalResult = (char)(11 - bodyRatio + ASCII_ZERO);
	    
	    return finalResult;
	}
	
	
	
	private char getNumberDig14(String cnpj) {
		final int CNPJ_BODY = 12;
		final int ASCII_ZERO = 48;
		
		int bodyProduct = 0;
	    int weight = 2;
	  
	    for (int i=CNPJ_BODY; i>=0; i--) {       
	      int eachNumber = (int)(cnpj.charAt(i) - ASCII_ZERO); 
	      bodyProduct = bodyProduct + (eachNumber * weight);
	      weight = weight + 1;
	      
	      if (weight == 10)
	    	  weight = 2;
	    }
	    
	    
	    int bodyRatio = bodyProduct % 11;
	    char finalResult = '0';
	      
	    if ((bodyRatio != 0) && (bodyRatio != 1)) 
	   	  finalResult = (char)(11 - bodyRatio + ASCII_ZERO);
	    
	    return finalResult;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CNPJ_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CNPJ_INVALID;
	}
}
