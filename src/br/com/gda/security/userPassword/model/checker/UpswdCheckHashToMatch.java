package br.com.gda.security.userPassword.model.checker;

import java.sql.Connection;
import java.util.Arrays;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdCheckHashToMatch extends ModelCheckerTemplateSimple_<UpswdInfo> {

	public UpswdCheckHashToMatch() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hash 		== null ||
			recordInfo.hashToMatch	== null		)			
			return FAILED;
		
		
		if (Arrays.equals(recordInfo.hash, recordInfo.hashToMatch))
			return SUCCESS;
		
		
		return FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
}
