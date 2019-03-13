package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StowotmCheckDeleteAll extends ModelCheckerTemplateSimple<StowotmInfo> {
	
	public StowotmCheckDeleteAll() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StowotmInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.username		== null	)
			
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
