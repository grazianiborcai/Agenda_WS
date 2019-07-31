package br.com.gda.payment.statusPayOrder.info;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.business.masterData.info.common.PaymentStatusMoip;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PaytusSetterOrderStatus implements InfoSetter<PaytusInfo> {
	
	public PaytusInfo setAttr(PaytusInfo recordInfo) {
		checkArgument(recordInfo);
		
		PaymentStatusMoip status = getPaymentStatus(recordInfo);
		
		recordInfo = setDefault(recordInfo);	
		recordInfo = setWaiting(recordInfo, status);
		recordInfo = setPaid(recordInfo, status);
		recordInfo = setNotPaid(recordInfo, status);

		return recordInfo;
	}
	
	
	
	private PaymentStatusMoip getPaymentStatus(PaytusInfo recordInfo) {
		if (recordInfo.statusPaymentPartner == null)
			return null;
		
		return PaymentStatusMoip.getStatus(recordInfo.statusPaymentPartner);
	}
	
	
	
	private PaytusInfo setDefault(PaytusInfo recordInfo) {
		recordInfo.codOrderStatus = OrderStatus.WAITING.getCodStatus();
		return recordInfo;
	}
	
	
	
	private PaytusInfo setWaiting(PaytusInfo recordInfo, PaymentStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status.isOnWait())
			recordInfo.codOrderStatus = OrderStatus.WAITING.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private PaytusInfo setPaid(PaytusInfo recordInfo, PaymentStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status.isPaid())
			recordInfo.codOrderStatus = OrderStatus.PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private PaytusInfo setNotPaid(PaytusInfo recordInfo, PaymentStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status.isNotPaid())
			recordInfo.codOrderStatus = OrderStatus.NOT_PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(PaytusInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
