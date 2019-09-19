package br.com.gda.business.scheduleMoviment.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SchedovmCheckHasCounter extends ModelCheckerTemplateSimple_<SchedovmInfo> {

	public SchedovmCheckHasCounter() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedovmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.confirmed 	!= 0 || 
			 recordInfo.waiting 	!= 0 || 
			 recordInfo.counter 	!= 0	)
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_MOV_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_MOV_MANDATORY_FIELD_EMPTY;
	}
}
