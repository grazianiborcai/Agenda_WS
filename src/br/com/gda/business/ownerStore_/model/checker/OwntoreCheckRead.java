package br.com.gda.business.ownerStore_.model.checker;

import java.sql.Connection;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class OwntoreCheckRead extends ModelCheckerTemplateSimple_<OwntoreInfo> {

	public OwntoreCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OwntoreInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
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
