package br.com.gda.business.company.model.checker;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CompCheckCnpjOnlyNumber extends ModelCheckerTemplateSimple_<CompInfo> {

	public CompCheckCnpjOnlyNumber() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cnpj.matches("^\\d+$"))			
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.COMPANY_CNPJ_INVALID_NUMBER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.COMPANY_CNPJ_INVALID_NUMBER;
	}
}
