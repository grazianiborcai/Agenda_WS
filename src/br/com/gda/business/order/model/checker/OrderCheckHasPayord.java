package br.com.gda.business.order.model.checker;

import java.sql.Connection;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrderCheckHasPayord extends ModelCheckerTemplateSimple<OrderInfo> {

	public OrderCheckHasPayord() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayOrder <= 0)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_DONT_HAVE_PAYMENT;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_DONT_HAVE_PAYMENT;
	}
}
