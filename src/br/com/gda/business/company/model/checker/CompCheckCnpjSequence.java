package br.com.gda.business.company.model.checker;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class CompCheckCnpjSequence extends ModelCheckerTemplateSimpleV2<CompInfo> {

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
