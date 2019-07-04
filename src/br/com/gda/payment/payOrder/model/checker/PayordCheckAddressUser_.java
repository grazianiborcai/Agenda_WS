package br.com.gda.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordCheckAddressUser_ extends ModelCheckerTemplateSimple<PayordInfo> {

	public PayordCheckAddressUser_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addressPayData == null)
			return super.FAILED;
		
		if (recordInfo.addressPayData.codUser == recordInfo.codUser)
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_ADDRESS_DIF_USER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_ADDRESS_DIF_USER;
	}
}
