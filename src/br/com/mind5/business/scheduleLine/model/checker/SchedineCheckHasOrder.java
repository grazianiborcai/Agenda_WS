package br.com.mind5.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class SchedineCheckHasOrder extends ModelCheckerTemplateSimple_<SchedineInfo> {

	public SchedineCheckHasOrder() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOrder <= 0 )		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_HAS_NO_ORDER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_HAS_NO_ORDER;
	}
}
