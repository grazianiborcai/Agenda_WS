package br.com.gda.business.company.model.checker;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CompCheckCnpjSequence extends ModelCheckerTemplateSimple_<CompInfo> {

	public CompCheckCnpjSequence() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cnpj == null)
			return super.FAILED;
		
		
		if (checkSequence(recordInfo.cnpj))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private boolean checkSequence(String cnpj) {
		boolean IS_MONODIGIT = true;
		
		if (cnpj.matches("^(\\d)\\1+$") == IS_MONODIGIT) 
			return FAILED;		
	    
	    return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.COMPANY_CNPJ_INVALID_SEQUENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.COMPANY_CNPJ_INVALID_SEQUENCE;
	}
}
