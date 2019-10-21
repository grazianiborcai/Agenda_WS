package br.com.mind5.business.storeTime_.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeTime_.info.StorimeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class StorimeCheckReadWrite extends ModelCheckerTemplateSimple_<StorimeInfo> {

	public StorimeCheckReadWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StorimeInfo recordInfo, Connection conn, String schemaName) {	
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
