package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckUserAddress extends ModelCheckerTemplateSimple_<CrecardInfo> {

	public CrecardCheckUserAddress() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addressData == null)		
			return super.FAILED;
		
		
		
		if (recordInfo.codUser != recordInfo.addressData.codUser)			
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
