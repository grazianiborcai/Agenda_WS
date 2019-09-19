package br.com.gda.business.order.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class OrderCheckCancelStatus extends ModelCheckerTemplateSimple_<OrderInfo> {

	public OrderCheckCancelStatus() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatus == null)
			return super.FAILED;		
		
		if (isStatusCreated(recordInfo.codOrderStatus))
			return super.SUCCESS;
		
		if (isStatusPlaced(recordInfo.codOrderStatus))
			return super.SUCCESS;
		
		if (isStatusNotPaid(recordInfo.codOrderStatus))
			return super.SUCCESS;
		
		if (isStatusPaid(recordInfo.codOrderStatus))
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusCreated(String codOrderStatus) {		
		OrderStatus status = OrderStatus.getOrderStatus(codOrderStatus);
		
		if(status == OrderStatus.CREATED)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusPlaced(String codOrderStatus) {		
		OrderStatus status = OrderStatus.getOrderStatus(codOrderStatus);
		
		if(status == OrderStatus.PLACED)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusNotPaid(String codOrderStatus) {		
		OrderStatus status = OrderStatus.getOrderStatus(codOrderStatus);
		
		if(status == OrderStatus.NOT_PAID)
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
