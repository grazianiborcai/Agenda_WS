package br.com.gda.business.order.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrderCheckCancel extends ModelCheckerTemplateSimple<OrderInfo> {

	public OrderCheckCancel() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatus == null)
			return super.FAILED;
		
		
		if (recordInfo.codOrderStatus.equals(OrderStatus.CANCELLED.getCodStatus())	||
			recordInfo.codOrderStatus.equals(OrderStatus.PAID.getCodStatus()))
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
