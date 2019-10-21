package br.com.mind5.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckRead extends ModelCheckerTemplateSimple_<PayordemInfo> {

	public PayordemCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codPayOrder	<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
