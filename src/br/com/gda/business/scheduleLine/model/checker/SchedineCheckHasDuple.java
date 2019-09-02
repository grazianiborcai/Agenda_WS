package br.com.gda.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SchedineCheckHasDuple extends ModelCheckerTemplateSimple<SchedineInfo> {

	public SchedineCheckHasDuple(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
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
