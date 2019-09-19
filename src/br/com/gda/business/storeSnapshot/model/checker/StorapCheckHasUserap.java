package br.com.gda.business.storeSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class StorapCheckHasUserap extends ModelCheckerTemplateSimple_<StorapInfo> {

	public StorapCheckHasUserap() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StorapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codUserSnapshot <= 0)				
			return FAILED;		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.STORE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
