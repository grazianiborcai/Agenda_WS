package br.com.gda.message.emailBody.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.message.emailBody.info.EmabodyInfo;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class EmabodyCheckRead extends ModelCheckerTemplateSimple<EmabodyInfo> {

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
