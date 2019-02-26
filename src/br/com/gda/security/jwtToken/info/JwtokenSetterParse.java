package br.com.gda.security.jwtToken.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

public final class JwtokenSetterParse implements InfoSetter<JwtokenInfo> {	
	
	public JwtokenInfo setAttr(JwtokenInfo recordInfo) {
		checkArgument(recordInfo);
		return setParse(recordInfo);
	}
	
	
	
	private void checkArgument(JwtokenInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.tokenToVerify == null) {
			logException(new NullPointerException("recordInfo.tokenToVerify" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.tokenToVerify" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.secret == null) {
			logException(new NullPointerException("recordInfo.secret" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.secret" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private JwtokenInfo setParse(JwtokenInfo recordInfo) {
		try {
			Jwt<?, ?> parsedToken = Jwts.parser()
					                    .setSigningKey(recordInfo.secret)
                                        .parse(recordInfo.tokenToVerify);						
			
			Claims claim = (Claims) parsedToken.getBody();
			
			recordInfo.codOwner = Long.valueOf((String) claim.get("codOwner"));
			recordInfo.username = (String) claim.get("username");
			recordInfo.codPlatform = (String) claim.get("codPlatform");
			recordInfo.expirationTime = claim.getExpiration();			
			
			return recordInfo;
		
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
