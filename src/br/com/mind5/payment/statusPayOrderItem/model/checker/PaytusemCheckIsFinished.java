package br.com.mind5.payment.statusPayOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatusMoip;
import br.com.mind5.business.masterData.info.common.PaymentStatusMoip;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PaytusemCheckIsFinished extends ModelCheckerTemplateSimpleV2<PaytusemInfo> {

	public PaytusemCheckIsFinished(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_STATUS_ITEM_NOT_CHANGEABLE;
	}
}
