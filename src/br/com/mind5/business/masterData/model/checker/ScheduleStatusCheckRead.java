package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class ScheduleStatusCheckRead extends ModelCheckerTemplateSimple_<ScheduleStatusInfo> {
	
	public ScheduleStatusCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(ScheduleStatusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_STATUS_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_STATUS_MANDATORY_FIELD_EMPTY;
	}
}
