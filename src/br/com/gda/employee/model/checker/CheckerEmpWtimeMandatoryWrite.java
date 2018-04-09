package br.com.gda.employee.model.checker;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerEmpWtimeMandatoryWrite extends ModelCheckerTemplate<EmpWTimeInfo> {

	public CheckerEmpWtimeMandatoryWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.weekday		<= 0 )
			
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
