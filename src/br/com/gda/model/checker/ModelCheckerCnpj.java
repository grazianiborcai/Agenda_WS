package br.com.gda.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;

public final class ModelCheckerCnpj extends ModelCheckerTemplate<String> {

	public ModelCheckerCnpj() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(String cnpj, Connection conn, String schemaName) {	
		if (cnpj == null)
			return RESULT_SUCCESS;
		
		if (checkOnlyNumber(cnpj) == RESULT_FAILED)			
			return RESULT_FAILED;
		
		if (checkLength(cnpj) == RESULT_FAILED)			
			return RESULT_FAILED;
		
		if (checkSequence(cnpj) == RESULT_FAILED)			
			return RESULT_FAILED;
		
		if (checkNumberVerification(cnpj) == RESULT_FAILED)
			return RESULT_FAILED;
		
		
		return RESULT_SUCCESS;
	}
	
	
	
	private boolean checkOnlyNumber(String cnpj) {
	    return cnpj.matches("^\\d+$");
	}
	
	
	
	private boolean checkLength(String cnpj) {
	    if (cnpj.length() != 14)
	           return RESULT_FAILED;
	    
	    return RESULT_SUCCESS;
	}
	
	
	
	private boolean checkSequence(String cnpj) {
		boolean IS_MONODIGIT = true;
		
		if (cnpj.matches("^(\\d)\\1+$") == IS_MONODIGIT) 
			return RESULT_FAILED;		

	    
	    return RESULT_SUCCESS;
	}
	
	
	
	private boolean checkNumberVerification(String cnpj) {
	    char dig13 = getNumberVerificationDig13(cnpj);
	    char dig14 = getNumberVerificationDig14(cnpj);
	    
	    if (cnpj.charAt(12) == dig13 && cnpj.charAt(13) == dig14)
	    	return RESULT_SUCCESS;
	    
	    return RESULT_FAILED;
	}
	
	
	
	private char getNumberVerificationDig13(String cnpj) {
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
	
	
	
	private char getNumberVerificationDig14(String cnpj) {
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
