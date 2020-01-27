package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class AuthGrRoleCheckRead extends ModelCheckerTemplateSimpleV2<AuthGrRoleInfo> {

	public AuthGrRoleCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AuthGrRoleInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codAuthRole 	== null &&
			recordInfo.codAuthGroup == null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AUTH_ROLE_MANDATORY_FIELD_EMPTY;
	}
}
