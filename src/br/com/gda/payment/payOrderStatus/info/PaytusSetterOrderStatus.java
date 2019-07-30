package br.com.gda.payment.payOrderStatus.info;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.business.masterData.info.common.PaymentStatus;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PaytusSetterOrderStatus implements InfoSetter<PaytusInfo> {
	
	public PaytusInfo setAttr(PaytusInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo = setDefault(recordInfo);	
		recordInfo = setWaiting(recordInfo);
		recordInfo = setPaid(recordInfo);
		recordInfo = setNotPaid(recordInfo);

		return recordInfo;
	}
	
	
	
	private PaytusInfo setDefault(PaytusInfo recordInfo) {
		recordInfo.codOrderStatus = OrderStatus.CREATED.getCodStatus();
		return recordInfo;
	}
	
	
	
	private PaytusInfo setWaiting(PaytusInfo recordInfo) {
		if (recordInfo.statusPaymentPartner == null)
			return recordInfo;
		
		String status = PaymentStatus.WAITING.getCodStatus();
		
		if(recordInfo.statusPaymentPartner.equals(status))
			recordInfo.codOrderStatus = OrderStatus.WAITING.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private PaytusInfo setPaid(PaytusInfo recordInfo) {
		if (recordInfo.statusPaymentPartner == null)
			return recordInfo;
		
		String statusAuth = PaymentStatus.AUTHORIZED.getCodStatus();
		String statusAcpt = PaymentStatus.ACCEPTED.getCodStatus();
		
		if(recordInfo.statusPaymentPartner.equals(statusAuth)	||
		   recordInfo.statusPaymentPartner.equals(statusAcpt)		)
			recordInfo.codOrderStatus = OrderStatus.PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	private PaytusInfo setNotPaid(PaytusInfo recordInfo) {
		if (recordInfo.statusPaymentPartner == null)
			return recordInfo;
		
		String status = PaymentStatus.REFUSED.getCodStatus();
		
		if(recordInfo.statusPaymentPartner.equals(status))
			recordInfo.codOrderStatus = OrderStatus.NOT_PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(PaytusInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
