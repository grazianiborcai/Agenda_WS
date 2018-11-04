package br.com.gda.model.checker.common;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class ModelCheckerCpf extends ModelCheckerTemplateSimple<String> {

	public ModelCheckerCpf() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(String cpf, Connection conn, String schemaName) {	
		if (cpf == null)
			return SUCCESS;
		
		if (checkOnlyNumber(cpf) == FAILED)			
			return FAILED;
		
		if (checkLength(cpf) == FAILED)			
			return FAILED;
		
		if (checkSequence(cpf) == FAILED)			
			return FAILED;
		
		if (checkNumberVerification(cpf) == FAILED)
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkOnlyNumber(String cpf) {
	    return cpf.matches("^\\d+$");
	}
	
	
	
	private boolean checkLength(String cpf) {
	    if (cpf.length() != 11)
	           return FAILED;
	    
	    return SUCCESS;
	}
	
	
	
	private boolean checkSequence(String cpf) {
	    if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") 	  )
	           return FAILED;
	    
	    return SUCCESS;
	}
	
	
	
	private boolean checkNumberVerification(String cpf) {
	    char dig10 = getNumberVerificationDig10(cpf);
	    char dig11 = getNumberVerificationDig11(cpf);
	    
	    if (cpf.charAt(9) == dig10 && cpf.charAt(10) == dig11)
	    	return SUCCESS;
	    
	    return FAILED;
	}
	
	
	
	private char getNumberVerificationDig10(String cpf) {
		final int CPF_BODY = 9;
		final int ASCII_ZERO = 48;
		
		int bodyProduct = 0;
	    int weight = 10;
	  
	    for (int i=0; i<CPF_BODY; i++) {       
	      int eachNumber = (int)(cpf.charAt(i) - ASCII_ZERO); 
	      bodyProduct = bodyProduct + (eachNumber * weight);
	      weight = weight - 1;
	    }
	    
	    
	    int bodyRatio = 11 - (bodyProduct % 11);
	    char finalResult = '0';
	      
	    if ((bodyRatio != 10) && (bodyRatio != 11)) 
	   	  finalResult = (char)(bodyRatio + ASCII_ZERO);
	    
	    return finalResult;
	}
	
	
	
	private char getNumberVerificationDig11(String cpf) {
		final int CPF_BODY = 10;
		final int ASCII_ZERO = 48;
		
		int bodyProduct = 0;
	    int weight = 11;
	  
	    for (int i=0; i<CPF_BODY; i++) {       
	      int eachNumber = (int)(cpf.charAt(i) - ASCII_ZERO); 
	      bodyProduct = bodyProduct + (eachNumber * weight);
	      weight = weight - 1;
	    }
	    
	    
	    int bodyRatio = 11 - (bodyProduct % 11);
	    char finalResult = '0';
	      
	    if ((bodyRatio != 10) && (bodyRatio != 11)) 
	   	  finalResult = (char)(bodyRatio + ASCII_ZERO);
	    
	    return finalResult;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CPF_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CPF_INVALID;
	}
}
