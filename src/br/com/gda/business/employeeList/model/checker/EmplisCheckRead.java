package br.com.gda.business.employeeList.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class EmplisCheckRead extends ModelCheckerTemplateSimple<EmplisInfo> {

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
