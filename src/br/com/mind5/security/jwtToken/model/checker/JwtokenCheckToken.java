package br.com.mind5.security.jwtToken.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

public final class JwtokenCheckToken extends ModelCheckerTemplateSimple_<JwtokenInfo> {

	public JwtokenCheckToken() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(JwtokenInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.tokenToVerify	== null	||
			recordInfo.secret			== null ||
			recordInfo.algo				== null)			
			return super.FAILED;	
		
		return checkToken(recordInfo);
	}
	
	
	
	private boolean checkToken(JwtokenInfo recordInfo) {
		try {
			Jwt<?, ?> parsedToken = Jwts.parser()
					                    .setSigningKey(recordInfo.secret)
                                        .parse(recordInfo.tokenToVerify);			
			
			
			Object algo = parsedToken.getHeader().get("alg");
			
			if (recordInfo.algo.getValue().equals(algo))
				return super.SUCCESS;
			
			
			return super.FAILED;
		
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
