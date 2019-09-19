package br.com.gda.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SchedineCheckCancel extends ModelCheckerTemplateSimple_<SchedineInfo> {

	public SchedineCheckCancel() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codSchedule	<= 0
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage	== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_MANDATORY_FIELD_EMPTY;
	}
}
