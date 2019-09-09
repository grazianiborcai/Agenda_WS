package br.com.gda.business.scheduleWeek.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SchedeekCheckRead extends ModelCheckerTemplateSimple<SchedeekInfo> {

	public SchedeekCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedeekInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.year 		<= 0 	|| 
			 recordInfo.month 		<= 0 	|| 
			 recordInfo.weekMonth 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_WEEK_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_WEEK_FIELD_EMPTY;
	}
}
