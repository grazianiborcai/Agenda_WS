package br.com.mind5.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCrecardUser extends ModelCheckerTemplateSimple_<PayordInfo> {

	public PayordCheckCrecardUser() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.crecardData == null)
			return super.FAILED;
		
		if (recordInfo.crecardData.codPayCustomer == recordInfo.codPayCustomer)
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
