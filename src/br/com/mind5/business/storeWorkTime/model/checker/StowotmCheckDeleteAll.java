package br.com.mind5.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class StowotmCheckDeleteAll extends ModelCheckerTemplateSimple_<StowotmInfo> {
	
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
