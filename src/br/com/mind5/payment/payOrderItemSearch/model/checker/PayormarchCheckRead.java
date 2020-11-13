package br.com.mind5.payment.payOrderItemSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayormarchCheckRead extends ModelCheckerTemplateSimple<PayormarchInfo> {

	public PayormarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayormarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;		
		
		
		if ( recordInfo.codPayOrder	<= 0 &&
			 recordInfo.codOrder	<= 0	)
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
