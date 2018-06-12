package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class EmpWTimeCheckWrite extends ModelCheckerTemplate<EmpWTimeInfo> {

	public EmpWTimeCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.codWeekday	<= 0 	|| 
			recordInfo.codTimezone	== null	||
			recordInfo.beginTime	== null	||
			recordInfo.endTime		== null		)
			
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
