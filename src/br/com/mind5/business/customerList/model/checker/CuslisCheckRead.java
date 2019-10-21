package br.com.mind5.business.customerList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CuslisCheckRead extends ModelCheckerTemplateSimple_<CuslisInfo> {

	public CuslisCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CuslisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CUS_LIST_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CUS_LIST_MANDATORY_FIELD_EMPTY;
	}
}
