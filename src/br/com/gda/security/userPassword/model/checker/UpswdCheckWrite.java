package br.com.gda.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdCheckWrite extends ModelCheckerTemplateSimple_<UpswdInfo> {

	public UpswdCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 	<= 0 	
			|| recordInfo.codUser 	<= 0
			|| recordInfo.password	== null	)
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_PASSWORD_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_PASSWORD_MANDATORY_FIELD_EMPTY;
	}
}
