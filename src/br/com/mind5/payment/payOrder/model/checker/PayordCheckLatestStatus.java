package br.com.mind5.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatusMoip;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckLatestStatus extends ModelCheckerTemplateSimple_<PayordInfo> {

	public PayordCheckLatestStatus() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.latestData == null)
			return super.SUCCESS;		
		
		if (recordInfo.latestData.statusOrderPartner == null)
			return super.SUCCESS;	
		
		
		OrderStatusMoip status = getOrderStatus(recordInfo);		
		
		if (status.isNotPaid())			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private OrderStatusMoip getOrderStatus(PayordInfo recordInfo) {
		return OrderStatusMoip.getStatus(recordInfo.latestData.statusOrderPartner);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_PAYMENT_ALREADY_EXIST;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_PAYMENT_ALREADY_EXIST;
	}
}
