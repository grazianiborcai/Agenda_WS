package br.com.mind5.masterData.orderStatus.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OrderatusCheckRead extends ModelCheckerTemplateSimple<OrderatusInfo> {
	
	public OrderatusCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrderatusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOrderStatus 	== null ||
			 recordInfo.codLanguage 	== null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_STATUS_MANDATORY_FIELD_EMPTY;
	}
}
