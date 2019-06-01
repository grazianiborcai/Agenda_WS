package br.com.gda.business.order.model.checker;

import java.sql.Connection;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrderCheckInsert extends ModelCheckerTemplateSimple<OrderInfo> {

	public OrderCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.grandTotal	<= 0 	
			|| recordInfo.codCurr		== null 
			|| recordInfo.cartems		== null 
			|| recordInfo.username		== null 
			|| recordInfo.cartems		== null
			|| recordInfo.codLanguage 	== null )
			
			return super.FAILED;
		
		
		if (recordInfo.cartems.isEmpty())
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
