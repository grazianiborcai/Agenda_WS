package br.com.mind5.business.order.model.checker;

import java.sql.Connection;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OrderCheckInsert extends ModelCheckerTemplateSimpleV2<OrderInfo> {

	public OrderCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrderInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.grandTotal	<= 0 	
			|| recordInfo.codCurr		== null 
			|| recordInfo.orderms		== null 
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage 	== null )
			
			return super.FAILED;
		
		
		if (recordInfo.orderms.isEmpty())
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
