package br.com.gda.payment.statusPayOrderItem.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.OrderStatusMoip;
import br.com.gda.business.masterData.info.common.PaymentStatusMoip;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PaytusemCheckIsFinished extends ModelCheckerTemplateSimple<PaytusemInfo> {

	public PaytusemCheckIsFinished() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaytusemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.statusOrderPartner 	== null	||
			recordInfo.statusPaymentPartner == null 	)
			
			return super.FAILED;
		
		
		if (checkOrderStatus(recordInfo)	== false ||
			checkPaymentStatus(recordInfo)	== false	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkOrderStatus(PaytusemInfo recordInfo) {
		OrderStatusMoip statusOrder = OrderStatusMoip.getStatus(recordInfo.statusOrderPartner);
		
		if (statusOrder.isChangeable())
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkPaymentStatus(PaytusemInfo recordInfo) {
		PaymentStatusMoip paymentStatus = PaymentStatusMoip.getStatus(recordInfo.statusPaymentPartner);
		
		if (paymentStatus.isChangeable())
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_STATUS_NOT_CHANGEABLE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_STATUS_NOT_CHANGEABLE;
	}
}
