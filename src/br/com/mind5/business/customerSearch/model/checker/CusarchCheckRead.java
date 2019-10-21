package br.com.mind5.business.customerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CusarchCheckRead extends ModelCheckerTemplateSimple_<CusarchInfo> {

	public CusarchCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codLanguage 	== null		)			
			return super.FAILED;		
		
		
		if (recordInfo.codCustomer 	<= 0 	&&
			recordInfo.codUser 		<= 0 	&&
			recordInfo.personData	== null &&
			recordInfo.phoneData	== null		)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CUSTOMER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CUSTOMER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
