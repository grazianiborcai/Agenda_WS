package br.com.gda.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CrecardCheckHasCuspar extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckHasCuspar() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codPayCustomer 	<= 0)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_EMPTY_CUSPAR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_EMPTY_CUSPAR;
	}
}
