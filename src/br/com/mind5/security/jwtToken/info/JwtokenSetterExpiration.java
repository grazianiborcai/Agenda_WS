package br.com.mind5.security.jwtToken.info;

import java.util.Date;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class JwtokenSetterExpiration extends InfoSetterTemplate<JwtokenInfo> {
	private final int MINUTE = 60000;
	private final int HOUR = MINUTE * 60;
	private final long EXPIRATION_TIME = HOUR * 4;
	
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		Date now = DefaultValue.dateNow();		
		recordInfo.expirationTime = new Date(now.getTime() + EXPIRATION_TIME);
		return recordInfo;
	}
}
