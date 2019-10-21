package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckDelete extends ModelCheckerTemplateSimple_<CrecardInfo> {

	public CrecardCheckDelete() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.codPayCustomer	<= 0	||		 
			 recordInfo.codCreditCard	<= 0	||	
			 recordInfo.codLanguage 	== null ||
			 recordInfo.username 		== null 	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MANDATORY_FIELD_EMPTY;
	}
}
