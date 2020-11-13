package br.com.mind5.security.userAuthentication.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class UauthCheckRead extends ModelCheckerTemplateSimple<UauthInfo> {

	public UauthCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UauthInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.username		== null	||
			recordInfo.password		== null	||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_AUTH_MANDATORY_FIELD_EMPTY;
	}
}
