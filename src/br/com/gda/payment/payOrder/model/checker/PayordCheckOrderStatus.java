package br.com.gda.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordCheckOrderStatus extends ModelCheckerTemplateSimple<PayordInfo> {

	public PayordCheckOrderStatus() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatus == null)
			return super.FAILED;
		
		if (recordInfo.codOrderStatus.equals(OrderStatus.WAITING.getCodStatus()) 	||
			recordInfo.codOrderStatus.equals(OrderStatus.NOT_PAID.getCodStatus())		)			
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_STATUS_NOT_ALLOWED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_STATUS_NOT_ALLOWED;
	}
}
