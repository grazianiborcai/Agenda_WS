package br.com.gda.business.feeStore.model.checker;

import java.sql.Connection;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FeeStoreCheckRead extends ModelCheckerTemplateSimple<FeetoreInfo> {

	public FeeStoreCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FeetoreInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner <= 0
			|| recordInfo.codStore <= 0
			|| recordInfo.codLanguage == null
			|| recordInfo.codFeeCateg == DefaultValue.character() )			
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
