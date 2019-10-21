package br.com.mind5.business.customerSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CusnapCheckWrite extends ModelCheckerTemplateSimple_<CusnapInfo> {

	public CusnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusnapInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	<= 0 
			 || recordInfo.codCustomer	<= 0
			 || recordInfo.codLanguage  == null	
			 || recordInfo.username 	== null	)
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
