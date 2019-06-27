package br.com.gda.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CrecardCheckWrite extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||	
			 recordInfo.codPayCustomer	<= 0 	||
			 recordInfo.creditCardId 	== null ||
			 recordInfo.codLanguage 	== null ||
			 recordInfo.username 		== null 	)
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
