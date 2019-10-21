package br.com.mind5.business.customer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CusCheckWrite extends ModelCheckerTemplateSimple_<CusInfo> {

	public CusCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	<= 0 
			 || recordInfo.codCustomer	<= 0
			 || recordInfo.personData   == null
			 || recordInfo.codLanguage  == null	
			 || recordInfo.username 	== null	)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CUS_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CUS_MANDATORY_FIELD_EMPTY;
	}
}
