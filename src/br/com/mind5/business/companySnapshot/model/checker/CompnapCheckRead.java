package br.com.mind5.business.companySnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CompnapCheckRead extends ModelCheckerTemplateSimple_<CompnapInfo> {

	public CompnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CompnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codSnapshot <= 0		)			
			return FAILED;		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.COMPANY_SNAP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.COMPANY_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
