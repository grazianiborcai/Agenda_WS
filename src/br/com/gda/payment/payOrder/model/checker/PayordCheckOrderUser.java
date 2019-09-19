package br.com.gda.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordCheckOrderUser extends ModelCheckerTemplateSimple_<PayordInfo> {

	public PayordCheckOrderUser() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.orderData == null)
			return super.FAILED;
		
		
		if (recordInfo.orderData.codUser == recordInfo.codUser)
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_DIF_ORDER_USER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_DIF_ORDER_USER;
	}
}
