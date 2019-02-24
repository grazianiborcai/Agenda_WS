package br.com.gda.security.jwtToken.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.security.jwtToken.info.JwtokenInfo;

public final class JwtokenCheckValidate extends ModelCheckerTemplateSimple<JwtokenInfo> {

	public JwtokenCheckValidate() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(JwtokenInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 		<= 0 	||
			recordInfo.username 		== null	||
			recordInfo.codPlatform		== null	||
			recordInfo.expirationTime	== null ||
			recordInfo.token			== null		)			
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
