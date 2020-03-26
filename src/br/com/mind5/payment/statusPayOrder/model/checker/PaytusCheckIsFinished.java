package br.com.mind5.payment.statusPayOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatusMoip;
import br.com.mind5.business.masterData.info.common.PaymentStatusMoip;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckIsFinished extends ModelCheckerTemplateSimple<PaytusInfo> {

	public PaytusCheckIsFinished(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaytusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.statusOrderPartner 	== null	||
			recordInfo.statusPaymentPartner == null 	)
				
				return super.FAILED;
			
			
			if (checkOrderStatus(recordInfo)	== false ||
				checkPaymentStatus(recordInfo)	== false	)
				
				return super.FAILED;
			
			
			return super.SUCCESS;
	}
	
	
	
	private boolean checkOrderStatus(PaytusInfo recordInfo) {
		OrderStatusMoip statusOrder = OrderStatusMoip.getStatus(recordInfo.statusOrderPartner);
		
		if (statusOrder.isChangeable())
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkPaymentStatus(PaytusInfo recordInfo) {
		PaymentStatusMoip paymentStatus = PaymentStatusMoip.getStatus(recordInfo.statusPaymentPartner);
		
		if (paymentStatus.isChangeable())
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_STATUS_HEADER_NOT_CHANGEABLE;
	}
}
