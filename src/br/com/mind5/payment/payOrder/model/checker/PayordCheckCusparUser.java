package br.com.mind5.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCusparUser extends ModelCheckerTemplateSimple_<PayordInfo> {

	public PayordCheckCusparUser() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.cusparData == null)
			return super.FAILED;
		
		
		if (recordInfo.cusparData.codUser == recordInfo.codUser)
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_DIF_CUSPAR_USER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_DIF_CUSPAR_USER;
	}
}
