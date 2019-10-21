package br.com.mind5.payment.refundOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckRefund extends ModelCheckerTemplateSimple_<RefemInfo> {

	public RefemCheckRefund() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(RefemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.codPayOrder		<= 0 	||
			 recordInfo.codPayOrderItem	<= 0 	||
			 recordInfo.username		== null ||
			 recordInfo.codLanguage		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.REFUND_ITEM_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.REFUND_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
