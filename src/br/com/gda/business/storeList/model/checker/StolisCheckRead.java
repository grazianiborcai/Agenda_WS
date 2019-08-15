package br.com.gda.business.storeList.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StolisCheckRead extends ModelCheckerTemplateSimple<StolisInfo> {

	public StolisCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StolisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.STORE_LIST_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_LIST_MANDATORY_FIELD_EMPTY;
	}
}
