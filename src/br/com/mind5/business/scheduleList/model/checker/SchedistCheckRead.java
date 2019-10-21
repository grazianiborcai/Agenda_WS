package br.com.mind5.business.scheduleList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class SchedistCheckRead extends ModelCheckerTemplateSimple_<SchedistInfo> {

	public SchedistCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedistInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codSchedule <= 0 	|| 
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_LIST_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_LIST_MANDATORY_FIELD_EMPTY;
	}
}
