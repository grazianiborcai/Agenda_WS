package br.com.gda.business.ownerStore.model.checker;

import java.sql.Connection;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OwntoreCheckDelete extends ModelCheckerTemplateSimple<OwntoreInfo> {

	public OwntoreCheckDelete() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OwntoreInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.codStore 	<= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
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
