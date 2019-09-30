package br.com.gda.business.person.model.checker;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PersonCheckCpfNumber extends ModelCheckerTemplateSimpleV2<PersonInfo> {

	public PersonCheckCpfNumber(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cpf == null)
			return super.FAILED;
		
		
		if (checkNumber(recordInfo.cpf))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private boolean checkNumber(String cpf) {
	    char dig10 = getNumberDig10(cpf);
	    char dig11 = getNumberDig11(cpf);
	    
	    if (cpf.charAt(9) == dig10 && cpf.charAt(10) == dig11)
	    	return SUCCESS;
	    
	    return FAILED;
	}
	
	
	
	private char getNumberDig10(String cpf) {
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
	
	
	
	private char getNumberDig11(String cpf) {
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_CPF_INVALID;
	}
}
