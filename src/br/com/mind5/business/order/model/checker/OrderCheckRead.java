package br.com.mind5.business.order.model.checker;

import java.sql.Connection;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrderCheckRead extends ModelCheckerTemplateSimple_<OrderInfo> {

	public OrderCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codOrder 	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
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
