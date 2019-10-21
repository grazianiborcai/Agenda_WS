package br.com.mind5.payment.refundOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class RefuCheckRefund extends ModelCheckerTemplateSimple_<RefuInfo> {

	public RefuCheckRefund() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(RefuInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codPayOrder	<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.REFUND_HEADER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.REFUND_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
