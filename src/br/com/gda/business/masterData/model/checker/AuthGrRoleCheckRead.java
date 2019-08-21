package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class AuthGrRoleCheckRead extends ModelCheckerTemplateSimple<AuthGrRoleInfo> {

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
