package br.com.gda.business.scheduleWeekData.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SchedeekdatCheckRead extends ModelCheckerTemplateSimple_<SchedeekdatInfo> {

	public SchedeekdatCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedeekdatInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.year 		<= 0 	|| 
			 recordInfo.month 		<= 0 	|| 
			 recordInfo.weekMonth	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_WEEK_DATA_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_WEEK_DATA_FIELD_EMPTY;
	}
}
