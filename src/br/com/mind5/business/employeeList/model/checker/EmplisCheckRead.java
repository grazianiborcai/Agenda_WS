package br.com.mind5.business.employeeList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmplisCheckRead extends ModelCheckerTemplateSimple_<EmplisInfo> {

	public EmplisCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmplisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.EMP_LIST_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMP_LIST_MANDATORY_FIELD_EMPTY;
	}
}
