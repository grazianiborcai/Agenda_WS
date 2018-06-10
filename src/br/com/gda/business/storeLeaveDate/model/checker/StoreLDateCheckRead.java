package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class StoreLDateCheckRead extends ModelCheckerTemplate<StoreLDateInfo> {

	public StoreLDateCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreLDateInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 ||
			recordInfo.codStore <= 0)			
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
