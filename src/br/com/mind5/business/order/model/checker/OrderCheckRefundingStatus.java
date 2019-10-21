package br.com.mind5.business.order.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrderCheckRefundingStatus extends ModelCheckerTemplateSimple_<OrderInfo> {

	public OrderCheckRefundingStatus() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatus == null)
			return super.FAILED;	
		
		if (isStatusPaid(recordInfo.codOrderStatus))
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusPaid(String codOrderStatus) {		
		OrderStatus status = OrderStatus.getOrderStatus(codOrderStatus);
		
		if(status == OrderStatus.PAID)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_STATUS_CHANGE_NOT_ALLOWED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_STATUS_CHANGE_NOT_ALLOWED;
	}
}
