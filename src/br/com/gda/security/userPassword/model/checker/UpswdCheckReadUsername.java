package br.com.gda.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdCheckReadUsername extends ModelCheckerTemplateSimple<UpswdInfo> {

	public UpswdCheckReadUsername() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 	||
			recordInfo.username	== null ||
			recordInfo.password	== null		)			
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
