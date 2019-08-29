package br.com.gda.business.order.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrderCheckStatusChange extends ModelCheckerTemplateSimple<OrderInfo> {

	public OrderCheckStatusChange() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatus == null)
			return super.FAILED;
		
		
		boolean result = super.SUCCESS;
		OrderStatus status = OrderStatus.getOrderStatus(recordInfo.codOrderStatus);
		
		result = statusCancelled(status, result);
		
		return result;
	}
	
	
	
	private boolean statusCancelled(OrderStatus status, boolean result) {
		if (result == super.FAILED)
			return result;
		
		if(status == OrderStatus.CANCELLED)
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_STATUS_CHANGE_NOT_ALLOWED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_STATUS_CHANGE_NOT_ALLOWED;
	}
}
