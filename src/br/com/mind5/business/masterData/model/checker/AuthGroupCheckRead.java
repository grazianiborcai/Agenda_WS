package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AuthGroupCheckRead extends ModelCheckerTemplateSimple<AuthGroupInfo> {

	public AuthGroupCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AuthGroupInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codAuthGroup == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AUTH_GROUP_MANDATORY_FIELD_EMPTY;
	}
}
