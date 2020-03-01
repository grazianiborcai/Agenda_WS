package br.com.mind5.payment.payOrderSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchCheckRead extends ModelCheckerTemplateSimple_<PayordarchInfo> {

	public PayordarchCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		if ( recordInfo.codOrder    <= 0 &&
			 recordInfo.codUser     <= 0 &&
			 recordInfo.codPayOrder <= 0	)			
				
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
