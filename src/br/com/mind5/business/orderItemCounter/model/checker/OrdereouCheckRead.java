package br.com.mind5.business.orderItemCounter.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OrdereouCheckRead extends ModelCheckerTemplateSimple<OrdereouInfo> {

	public OrdereouCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdereouInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codOrder 	<= 0	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_ITEM_COUNTER_MANDATORY_FIELD_EMPTY;
	}
}
