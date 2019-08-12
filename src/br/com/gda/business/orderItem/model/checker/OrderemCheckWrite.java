package br.com.gda.business.orderItem.model.checker;

import java.sql.Connection;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrderemCheckWrite extends ModelCheckerTemplateSimple<OrderemInfo> {

	public OrderemCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderemInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codOrder		<= 0 	
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
