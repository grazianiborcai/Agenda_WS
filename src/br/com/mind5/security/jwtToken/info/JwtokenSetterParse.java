package br.com.mind5.security.jwtToken.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetterTemplate;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

public final class JwtokenSetterParse extends InfoSetterTemplate<JwtokenInfo> {	
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		try {
			Jwt<?, ?> parsedToken = Jwts.parser()
					                    .setSigningKey(recordInfo.secret)
                                        .parse(recordInfo.tokenToVerify);						
			
			Claims claim = (Claims) parsedToken.getBody();
			
			recordInfo.codOwner = Long.valueOf((String) claim.get("codOwner"));
			recordInfo.username = (String) claim.get("username");
			recordInfo.codPlatform = (String) claim.get("codPlatform");
			recordInfo.expirationTime = claim.getExpiration();			
			
			claim.clear();
			return recordInfo;
		
		} catch (Exception e) {
			super.logException(e);
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
}
