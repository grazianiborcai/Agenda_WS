package br.com.gda.business.feeStore.model.checker;

import java.sql.Connection;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FeeStoreCheckReadCateg extends ModelCheckerTemplateSimple<FeetoreInfo> {

	public FeeStoreCheckReadCateg() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FeetoreInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner <= 0
			|| recordInfo.codStore <= 0 )			
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
