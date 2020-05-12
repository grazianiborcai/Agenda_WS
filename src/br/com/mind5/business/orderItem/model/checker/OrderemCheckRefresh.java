package br.com.mind5.business.orderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OrderemCheckRefresh extends ModelCheckerTemplateSimpleV2<OrderemInfo> {

	public OrderemCheckRefresh(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrderemInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 
			|| recordInfo.codOrder 			<= 0 
			|| recordInfo.codOrderItem 		<= 0 
			|| recordInfo.codPayOrder 		<= 0 
			|| recordInfo.codPayOrderItem 	<= 0 
			|| recordInfo.username			== null 
			|| recordInfo.codLanguage 		== null )
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
