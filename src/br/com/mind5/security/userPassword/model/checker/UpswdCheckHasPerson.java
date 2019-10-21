package br.com.mind5.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckHasPerson extends ModelCheckerTemplateSimple_<UpswdInfo> {

	public UpswdCheckHasPerson() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.personData == null		)			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_PASSWORD_PERSON_IS_BLANK;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_PASSWORD_PERSON_IS_BLANK;
	}
}
