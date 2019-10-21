package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckTechField extends ModelCheckerTemplateSimple_<UserInfo> {
	
	public UserCheckTechField() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codUser >= 0 )			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_TECH_FIELD_SHOULD_BE_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_TECH_FIELD_SHOULD_BE_EMPTY;
	}
}
