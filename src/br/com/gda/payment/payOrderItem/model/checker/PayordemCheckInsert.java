package br.com.gda.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckInsert extends ModelCheckerTemplateSimple<PayordemInfo> {

	public PayordemCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codPayOrder	<= 0 
			|| recordInfo.itemNum		<= 0 
			|| recordInfo.codPayPartner <= 0
			|| recordInfo.quantity		<= 0
			|| recordInfo.price			<= 0
			|| recordInfo.totitem		<= 0
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage	== null	)
			
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
