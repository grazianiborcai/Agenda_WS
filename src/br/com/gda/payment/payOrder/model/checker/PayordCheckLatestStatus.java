package br.com.gda.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.PaymentStatusMoip;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordCheckLatestStatus extends ModelCheckerTemplateSimple<PayordInfo> {

	public PayordCheckLatestStatus() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.latestData == null)
			return super.SUCCESS;		
		
		if (recordInfo.latestData.statusPaymentPartner == null)
			return super.SUCCESS;	
		
		
		PaymentStatusMoip status = getPaymentStatus(recordInfo);		
		
		if (status.isNotPaid())			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private PaymentStatusMoip getPaymentStatus(PayordInfo recordInfo) {
		return PaymentStatusMoip.getStatus(recordInfo.latestData.statusPaymentPartner);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_PAYMENT_ALREADY_EXIST;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_PAYMENT_ALREADY_EXIST;
	}
}
