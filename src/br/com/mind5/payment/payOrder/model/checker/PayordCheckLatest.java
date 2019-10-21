package br.com.mind5.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckLatest extends ModelCheckerTemplateSimple_<PayordInfo> {

	public PayordCheckLatest() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codOrder    <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_HEADER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
