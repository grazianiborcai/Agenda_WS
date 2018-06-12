package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class StoreWTimeCheckWrite extends ModelCheckerTemplate<StoreWTimeInfo> {

	public StoreWTimeCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 	
			|| recordInfo.codStore 			<= 0
			|| recordInfo.codWeekday		<= 0
			|| recordInfo.codTimezone		== null
			|| recordInfo.beginTime			== null
			|| recordInfo.endTime			== null	)
			
			return RESULT_FAILED;
		
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
