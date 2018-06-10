package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class StoreWTimeCheckTime extends ModelCheckerTemplate<StoreWTimeInfo> {
	private final boolean OK = true;
	private final boolean BAD_RANGE = false;
	
	public StoreWTimeCheckTime() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.beginTime.isAfter(recordInfo.endTime))			
			return BAD_RANGE;		
		
		return OK;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.BAD_TIME_RANGE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.BAD_TIME_RANGE;
	}
}
