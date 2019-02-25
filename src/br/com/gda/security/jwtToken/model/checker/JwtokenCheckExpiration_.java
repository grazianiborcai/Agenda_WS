package br.com.gda.security.jwtToken.model.checker;

import java.sql.Connection;
import java.util.Date;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.security.jwtToken.info.JwtokenInfo;

public final class JwtokenCheckExpiration_ extends ModelCheckerTemplateSimple<JwtokenInfo> {

	public JwtokenCheckExpiration_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(JwtokenInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.expirationTime == null )			
			return super.FAILED;	
		
		
		Date now = DefaultValue.dateNow();
		
		
		if (now.after(recordInfo.expirationTime))
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.TOKEN_IS_EXPIRED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.TOKEN_IS_EXPIRED;
	}
}
