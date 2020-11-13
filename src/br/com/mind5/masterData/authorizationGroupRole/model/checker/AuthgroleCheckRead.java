package br.com.mind5.masterData.authorizationGroupRole.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AuthgroleCheckRead extends ModelCheckerTemplateSimple<AuthgroleInfo> {

	public AuthgroleCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AuthgroleInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codAuthRole 	== null &&
			recordInfo.codAuthGroup == null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AUTH_ROLE_MANDATORY_FIELD_EMPTY;
	}
}
