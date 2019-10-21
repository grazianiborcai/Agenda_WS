package br.com.mind5.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class SchedineCheckIsCancelled extends ModelCheckerTemplateSimple_<SchedineInfo> {

	public SchedineCheckIsCancelled() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.codScheduleStatus == null)
			return super.FAILED;
		
		ScheduleStatus status = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatus);
		
		if (status == ScheduleStatus.CANCELLED) 
			return super.SUCCESS;		
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_NOT_CANCELLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_MATERIAL_IS_NOT_SERVICE;
	}
}
