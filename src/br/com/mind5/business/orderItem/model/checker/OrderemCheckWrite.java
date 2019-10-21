package br.com.mind5.business.orderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrderemCheckWrite extends ModelCheckerTemplateSimple_<OrderemInfo> {

	public OrderemCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderemInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codOrder		<= 0 	
			|| recordInfo.codOrderItem	<= 0 
			|| recordInfo.codStore 		<= 0
			|| recordInfo.codMat		<= 0
			|| recordInfo.quantity		<= 0
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage	== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
