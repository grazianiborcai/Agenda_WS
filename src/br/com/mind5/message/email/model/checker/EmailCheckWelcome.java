package br.com.mind5.message.email.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmailCheckWelcome extends ModelCheckerTemplateSimple_<EmailInfo> {

	public EmailCheckWelcome() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmailInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.bodyData == null)
			return super.FAILED;
		
		
		if (recordInfo.bodyData.param01 == null ||
			recordInfo.bodyData.param02 == null		)				
			
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
