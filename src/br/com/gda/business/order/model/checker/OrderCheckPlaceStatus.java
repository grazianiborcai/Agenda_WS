package br.com.gda.business.order.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrderCheckPlaceStatus extends ModelCheckerTemplateSimple<OrderInfo> {

	public OrderCheckPlaceStatus() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatus == null)
			return super.FAILED;		
		
		if (isStatusCreated(recordInfo.codOrderStatus))
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusCreated(String codOrderStatus) {		
		OrderStatus status = OrderStatus.getOrderStatus(codOrderStatus);
		
		if(status == OrderStatus.CREATED)
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
