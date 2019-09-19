package br.com.gda.business.scheduleYearData.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SchedyeratCheckRead extends ModelCheckerTemplateSimple_<SchedyeratInfo> {

	public SchedyeratCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedyeratInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.year 		<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_YEAR_DATA_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_YEAR_DATA_FIELD_EMPTY;
	}
}
