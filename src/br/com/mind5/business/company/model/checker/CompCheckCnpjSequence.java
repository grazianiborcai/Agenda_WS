package br.com.mind5.business.company.model.checker;

import java.sql.Connection;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CompCheckCnpjSequence extends ModelCheckerTemplateSimple<CompInfo> {

	public CompCheckCnpjSequence(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CNPJ_INVALID_SEQUENCE;
	}
}
