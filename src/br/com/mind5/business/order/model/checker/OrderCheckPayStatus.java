package br.com.mind5.business.order.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OrderCheckPayStatus extends ModelCheckerTemplateSimpleV2<OrderInfo> {

	public OrderCheckPayStatus(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatus == null)
			return super.FAILED;		
		
		if (isStatusPlaced(recordInfo.codOrderStatus))
			return super.SUCCESS;
		
		if (isStatusNotPaid(recordInfo.codOrderStatus))
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_HEADER_STATUS_CHANGE_NOT_ALLOWED;
	}
}
