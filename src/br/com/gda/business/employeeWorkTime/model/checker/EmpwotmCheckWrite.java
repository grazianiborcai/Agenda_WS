package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class EmpwotmCheckWrite extends ModelCheckerTemplateSimple_<EmpwotmInfo> {

	public EmpwotmCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.codWeekday	<= 0 	|| 
			recordInfo.beginTime	== null	||
			recordInfo.endTime		== null	||
			recordInfo.codLanguage	== null ||
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
