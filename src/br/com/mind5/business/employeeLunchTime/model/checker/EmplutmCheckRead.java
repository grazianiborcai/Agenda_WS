package br.com.mind5.business.employeeLunchTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmplutmCheckRead extends ModelCheckerTemplateSimple<EmplutmInfo> {

	public EmplutmCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplutmInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.codWeekday 	<= 0 	||
			recordInfo.codLanguage	== null	||
			recordInfo.username		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LTIME_MANDATORY_FIELD_EMPTY;
	}
}
