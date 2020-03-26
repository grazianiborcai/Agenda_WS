package br.com.mind5.business.company.model.checker;

import java.sql.Connection;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CompCheckCnpjNumber extends ModelCheckerTemplateSimple<CompInfo> {

	public CompCheckCnpjNumber(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cnpj == null)
			return super.FAILED;
		
		
		if (checkNumber(recordInfo.cnpj))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private boolean checkNumber(String cnpj) {
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

	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CNPJ_INVALID;
	}
}
