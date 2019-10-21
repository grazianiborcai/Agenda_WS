package br.com.mind5.business.order.model.checker;

import java.sql.Connection;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrderCheckInsert extends ModelCheckerTemplateSimple_<OrderInfo> {

	public OrderCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.grandTotal	<= 0 	
			|| recordInfo.codCurr		== null 
			|| recordInfo.orderms		== null 
			|| recordInfo.username		== null 
			|| recordInfo.orderms		== null
			|| recordInfo.codLanguage 	== null )
			
			return super.FAILED;
		
		
		if (recordInfo.orderms.isEmpty())
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_HEADER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
