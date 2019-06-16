package br.com.gda.payment.customer.model.checker;

import java.sql.Connection;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PaycusCheckWrite extends ModelCheckerTemplateSimple<PaycusInfo> {

	public PaycusCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaycusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codPayCustomer 	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
