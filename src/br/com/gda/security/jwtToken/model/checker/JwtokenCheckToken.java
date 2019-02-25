package br.com.gda.security.jwtToken.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import io.jsonwebtoken.Jwts;

public final class JwtokenCheckToken extends ModelCheckerTemplateSimple<JwtokenInfo> {

	public JwtokenCheckToken() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(JwtokenInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.tokenEncoded	== null	||
			recordInfo.secret		== null		)			
			return super.FAILED;	
		
		return checkToken(recordInfo);
	}
	
	
	
	private boolean checkToken(JwtokenInfo recordInfo) {
		try {
			Jwts.parser().setSigningKey(recordInfo.secret)
			             .parse(recordInfo.tokenEncoded);
			
			return super.SUCCESS;
		
		} catch (Exception e) {
			return super.FAILED;
		}
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.TOKEN_IS_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.TOKEN_IS_INVALID;
	}
}
