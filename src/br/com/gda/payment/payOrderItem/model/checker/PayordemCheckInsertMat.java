package br.com.gda.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckInsertMat extends ModelCheckerTemplateSimple<PayordemInfo> {

	public PayordemCheckInsertMat() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codStore	<= 0	||
			recordInfo.codMat	<= 0		)
			
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
