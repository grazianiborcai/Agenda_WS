package br.com.mind5.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class SchedineCheckFromOrder extends ModelCheckerTemplateSimple_<SchedineInfo> {

	public SchedineCheckFromOrder() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codOrder		<= 0 
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
