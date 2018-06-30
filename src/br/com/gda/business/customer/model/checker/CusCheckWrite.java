package br.com.gda.business.customer.model.checker;

import java.sql.Connection;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CusCheckWrite extends ModelCheckerTemplate<CusInfo> {

	public CusCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 	<= 0 	
			|| recordInfo.cpf 		== null 	
			|| recordInfo.name 		== null
			|| recordInfo.email 	== null)
			
			return RESULT_FAILED;
		
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
