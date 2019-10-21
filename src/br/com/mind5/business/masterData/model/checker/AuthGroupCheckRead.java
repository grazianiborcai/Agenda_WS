package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class AuthGroupCheckRead extends ModelCheckerTemplateSimple_<AuthGroupInfo> {

	public AuthGroupCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AuthGroupInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codAuthGroup == null)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AUTH_GROUP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AUTH_GROUP_MANDATORY_FIELD_EMPTY;
	}
}
