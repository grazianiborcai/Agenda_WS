package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class AuthGrRoleCheckRead extends ModelCheckerTemplateSimple_<AuthGrRoleInfo> {

	public AuthGrRoleCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AuthGrRoleInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codAuthRole 	== null &&
			recordInfo.codAuthGroup == null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AUTH_ROLE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AUTH_ROLE_MANDATORY_FIELD_EMPTY;
	}
}
