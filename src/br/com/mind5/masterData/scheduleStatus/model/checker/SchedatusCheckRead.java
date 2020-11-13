package br.com.mind5.masterData.scheduleStatus.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SchedatusCheckRead extends ModelCheckerTemplateSimple<SchedatusInfo> {
	
	public SchedatusCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedatusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codScheduleStatus 	== null ||
			 recordInfo.codLanguage 		== null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_STATUS_MANDATORY_FIELD_EMPTY;
	}
}
