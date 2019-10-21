package br.com.mind5.security.jwtToken.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class JwtokenCheckValidate extends ModelCheckerTemplateSimple_<JwtokenInfo> {

	public JwtokenCheckValidate() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(JwtokenInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.tokenToVerify == null)			
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
