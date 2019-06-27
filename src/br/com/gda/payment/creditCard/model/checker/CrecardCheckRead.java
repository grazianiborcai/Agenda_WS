package br.com.gda.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CrecardCheckRead extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
