package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckHasPaypar extends ModelCheckerTemplateSimple_<CrecardInfo> {

	public CrecardCheckHasPaypar() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codPayPartner <= 0)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_EMPTY_PAYPAR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_EMPTY_PAYPAR;
	}
}
