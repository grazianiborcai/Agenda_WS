package br.com.gda.security.tokenAuthentication.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;

public final class TauthCheckRead extends ModelCheckerTemplateSimple_<TauthInfo> {

	public TauthCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(TauthInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.tokenToVerify 	== null	||
			recordInfo.codLanguage 		== null		)			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
