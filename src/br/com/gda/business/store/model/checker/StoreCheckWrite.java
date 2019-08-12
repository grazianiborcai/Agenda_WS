package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StoreCheckWrite extends ModelCheckerTemplateSimple<StoreInfo> {

	public StoreCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 
			|| recordInfo.personData 	== null 	
			|| recordInfo.companyData 	== null
			|| recordInfo.codLanguage 	== null
			|| recordInfo.codCurr 		== null
			|| recordInfo.username 		== null 
			|| recordInfo.codTimezone	== null	)
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.STORE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_MANDATORY_FIELD_EMPTY;
	}
}
