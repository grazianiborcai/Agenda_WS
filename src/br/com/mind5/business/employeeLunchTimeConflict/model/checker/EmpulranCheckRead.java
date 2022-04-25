package br.com.mind5.business.employeeLunchTimeConflict.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmpulranCheckRead extends ModelCheckerTemplateSimple<EmpulranInfo> {

	public EmpulranCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpulranInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee  <= 0 	||
			recordInfo.codWeekday	<= 0 	||
			recordInfo.codLanguage	== null ||
			recordInfo.username		== null ||
			recordInfo.beginTime	== null ||
			recordInfo.endTime		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LTIME_RANGE_MANDATORY_FIELD_EMPTY;
	}
}
