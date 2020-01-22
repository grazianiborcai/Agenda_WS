package br.com.mind5.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class SchedineCheckHasDuple_ extends ModelCheckerTemplateSimple_<SchedineInfo> {

	public SchedineCheckHasDuple_(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.dupleData == null )					
			return super.FAILED;
		
		if ( recordInfo.dupleData.codSchedule <= 0 )					
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.SCHEDULE_NOT_TAKEN)
			return SystemMessage.SCHEDULE_NOT_TAKEN;
		
		return SystemMessage.SCHEDULE_ALREADY_TAKEN;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.SCHEDULE_ALREADY_TAKEN;	
			
		return SystemCode.SCHEDULE_NOT_TAKEN;
	}
}
