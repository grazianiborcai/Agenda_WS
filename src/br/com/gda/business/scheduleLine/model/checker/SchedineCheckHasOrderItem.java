package br.com.gda.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SchedineCheckHasOrderItem extends ModelCheckerTemplateSimple_<SchedineInfo> {

	public SchedineCheckHasOrderItem() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOrder 	 <= 0 ||
			 recordInfo.codOrderItem <= 0	)		
			
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
