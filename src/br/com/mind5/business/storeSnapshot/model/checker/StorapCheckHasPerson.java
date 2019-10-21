package br.com.mind5.business.storeSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class StorapCheckHasPerson extends ModelCheckerTemplateSimple_<StorapInfo> {

	public StorapCheckHasPerson() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StorapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codPerson <= 0)				
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
