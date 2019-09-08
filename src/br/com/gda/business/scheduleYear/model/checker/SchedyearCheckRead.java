package br.com.gda.business.scheduleYear.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SchedyearCheckRead extends ModelCheckerTemplateSimple<SchedyearInfo> {

	public SchedyearCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedyearInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.year 		<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_YEAR_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_YEAR_FIELD_EMPTY;
	}
}
