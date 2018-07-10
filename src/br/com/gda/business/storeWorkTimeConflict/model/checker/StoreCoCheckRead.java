package br.com.gda.business.storeWorkTimeConflict.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StoreCoCheckRead extends ModelCheckerTemplateSimple<StoreCoInfo> {

	public StoreCoCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreCoInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codWeekday	<= 0 	||
			recordInfo.beginTime	== null ||
			recordInfo.endTime		== null		)
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
