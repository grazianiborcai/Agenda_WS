package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusCheckInsert extends ModelCheckerTemplateSimple<PaycusInfo> {

	public PaycusCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaycusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codUser  	<= 0 	||
			 recordInfo.codLanguage	== null		)
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
