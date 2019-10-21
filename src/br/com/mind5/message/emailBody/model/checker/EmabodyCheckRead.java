package br.com.mind5.message.emailBody.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmabodyCheckRead extends ModelCheckerTemplateSimple_<EmabodyInfo> {

	public EmabodyCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmabodyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null	||
			recordInfo.codBody		== null		)
			
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
