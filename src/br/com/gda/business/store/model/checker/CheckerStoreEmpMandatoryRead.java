package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerStoreEmpMandatoryRead extends ModelCheckerTemplate<StoreEmpInfo> {

	public CheckerStoreEmpMandatoryRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreEmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 )			
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
