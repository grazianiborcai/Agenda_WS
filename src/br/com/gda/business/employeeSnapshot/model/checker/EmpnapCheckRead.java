package br.com.gda.business.employeeSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class EmpnapCheckRead extends ModelCheckerTemplateSimple<EmpnapInfo> {

	public EmpnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpnapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codSnapshot 	<= 0 	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username		== null		)			
			return FAILED;		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
