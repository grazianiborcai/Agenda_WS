package br.com.mind5.business.order.model.checker;

import java.sql.Connection;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrderCheckHasPayord extends ModelCheckerTemplateSimple_<OrderInfo> {

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
