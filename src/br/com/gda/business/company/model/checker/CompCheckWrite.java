package br.com.gda.business.company.model.checker;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CompCheckWrite extends ModelCheckerTemplateSimple_<CompInfo> {

	public CompCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0	
			|| recordInfo.username			== null
			|| recordInfo.name 				== null
			|| recordInfo.codCountryLegal	== null
			|| recordInfo.codEntityCateg	== null )
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.COMPANY_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.COMPANY_MANDATORY_FIELD_EMPTY;
	}
}
