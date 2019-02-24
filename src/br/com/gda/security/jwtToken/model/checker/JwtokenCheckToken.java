package br.com.gda.security.jwtToken.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.security.jwtToken.info.JwtokenInfo;

public final class JwtokenCheckToken extends ModelCheckerTemplateSimple<JwtokenInfo> {

	public JwtokenCheckToken() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(JwtokenInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.token		== null	||
			recordInfo.tokenMirror	== null)			
			return super.FAILED;	
		
		if (recordInfo.token.equals(recordInfo.tokenMirror))
				return super.SUCCESS;	
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
