package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusCheckWriteAddress extends ModelCheckerTemplateSimple<PaycusInfo> {

	public PaycusCheckWriteAddress() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaycusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codAddressRef <= 0)
			return FAILED;
		
		
		return SUCCESS;
	}
	
	

	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_ADDRESS_IS_BLANK;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_ADDRESS_IS_BLANK;
	}
}
