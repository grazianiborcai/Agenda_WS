package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StoreWTimeCheckRead extends ModelCheckerTemplateSimple<StoreWTimeInfo> {

	public StoreWTimeCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 ||
			recordInfo.codStore <= 0)			
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
