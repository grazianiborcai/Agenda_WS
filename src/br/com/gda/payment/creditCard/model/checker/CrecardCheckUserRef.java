package br.com.gda.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CrecardCheckUserRef extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckUserRef() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addressData 	== null	||
			recordInfo.phoneData	== null		)
		
			return super.FAILED;
		
		
		
		if (recordInfo.codUser != recordInfo.addressData.codUser	|| 
			recordInfo.codUser != recordInfo.phoneData.codUser			)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_INVALID_USER_REF;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_INVALID_USER_REF;
	}
}
