package br.com.mind5.security.tokenAuthentication.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;

public final class TauthCheckRead extends ModelCheckerTemplateSimpleV2<TauthInfo> {

	public TauthCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(TauthInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.tokenToVerify 	== null	||
			recordInfo.codLanguage 		== null		)		
			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.TOKEN_AUTH_MANDATORY_FIELD_EMPTY;
	}
}
