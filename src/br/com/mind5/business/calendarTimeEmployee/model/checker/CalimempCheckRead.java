package br.com.mind5.business.calendarTimeEmployee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CalimempCheckRead extends ModelCheckerTemplateSimple<CalimempInfo> {

	public CalimempCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalimempInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore 	<= 0 	|| 
			 recordInfo.codEmployee <= 0 	|| 
			 recordInfo.date 		== null	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CAL_TIME_EMP_MANDATORY_FIELD_EMPTY;
	}
}
