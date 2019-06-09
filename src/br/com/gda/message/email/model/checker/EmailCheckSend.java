package br.com.gda.message.email.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class EmailCheckSend extends ModelCheckerTemplateSimple<EmailInfo> {

	public EmailCheckSend() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmailInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage 	== null	||
			recordInfo.recipientAddr	== null		)
			
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
