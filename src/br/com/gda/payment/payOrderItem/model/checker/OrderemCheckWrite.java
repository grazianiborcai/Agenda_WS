package br.com.gda.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class OrderemCheckWrite extends ModelCheckerTemplateSimple<PayordemInfo> {

	public OrderemCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codPayOrder		<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.codMat		<= 0
			|| recordInfo.quantity		<= 0
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage	== null	)
			
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
