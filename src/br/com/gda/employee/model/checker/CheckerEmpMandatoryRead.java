package br.com.gda.employee.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerEmpMandatoryRead extends ModelCheckerTemplate<EmpInfo> {

	public CheckerEmpMandatoryRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 ||
			recordInfo.codEmployee 	<= 0 )
			
			return RESULT_FAILED;
		
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
