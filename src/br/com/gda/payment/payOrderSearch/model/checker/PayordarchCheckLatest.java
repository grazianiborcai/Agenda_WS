package br.com.gda.payment.payOrderSearch.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchCheckLatest extends ModelCheckerTemplateSimple_<PayordarchInfo> {

	public PayordarchCheckLatest() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codOrder    <= 0 	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
