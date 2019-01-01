package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckWrite extends ModelCheckerTemplateSimple<PayCusInfo> {

	public PayCusCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayCusInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 		<= 0 
			 || recordInfo.codPayCustomer	<= 0
			 || recordInfo.codPerson		<= 0	)
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
