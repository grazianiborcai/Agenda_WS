package br.com.gda.business.customerSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CusnapCheckRead extends ModelCheckerTemplateSimple_<CusnapInfo> {

	public CusnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusnapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codCustomer 	<= 0 	||
			recordInfo.codSnapshot 	<= 0 	||
			recordInfo.codLanguage 	== null		)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CUS_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CUS_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
