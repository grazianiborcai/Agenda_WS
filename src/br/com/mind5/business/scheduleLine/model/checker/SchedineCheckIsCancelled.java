package br.com.mind5.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.scheduleStatus.info.Schedatus;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SchedineCheckIsCancelled extends ModelCheckerTemplateSimple<SchedineInfo> {

	public SchedineCheckIsCancelled(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.codScheduleStatus == null)
			return super.FAILED;
		
		Schedatus status = Schedatus.getScheduleStatus(recordInfo.codScheduleStatus);
		
		if (status == Schedatus.CANCELLED) 
			return super.SUCCESS;		
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_NOT_CANCELLED;
	}
}
