package br.com.mind5.payment.statusPayOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatusMoip;
import br.com.mind5.business.masterData.info.common.PaymentStatusMoip;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PaytusemCheckIsFinished extends ModelCheckerTemplateSimple_<PaytusemInfo> {

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
