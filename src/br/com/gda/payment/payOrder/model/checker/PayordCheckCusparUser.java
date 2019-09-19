package br.com.gda.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.payOrder.info.PayordInfo;

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
