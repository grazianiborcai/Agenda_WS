package br.com.gda.payment.payOrderSearch.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchCheckRead extends ModelCheckerTemplateSimple<PayordarchInfo> {

	public PayordarchCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		if ( recordInfo.codOrder    <= 0 &&
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
