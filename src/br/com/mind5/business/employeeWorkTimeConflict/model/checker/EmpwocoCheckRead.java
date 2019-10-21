package br.com.mind5.business.employeeWorkTimeConflict.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmpwocoCheckRead extends ModelCheckerTemplateSimple_<EmpwocoInfo> {

	public EmpwocoCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpwocoInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee  <= 0 	||
			recordInfo.codWeekday	<= 0 	||
			recordInfo.codLanguage	== null ||
			recordInfo.beginTime	== null ||
			recordInfo.endTime		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
