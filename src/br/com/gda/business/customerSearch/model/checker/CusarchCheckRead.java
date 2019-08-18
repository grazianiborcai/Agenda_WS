package br.com.gda.business.customerSearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CusarchCheckRead extends ModelCheckerTemplateSimple<CusarchInfo> {

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
