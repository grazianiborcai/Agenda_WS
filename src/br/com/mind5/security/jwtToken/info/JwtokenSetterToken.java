package br.com.mind5.security.jwtToken.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import io.jsonwebtoken.Jwts;

public final class JwtokenSetterToken implements InfoSetter<JwtokenInfo> {
	
	public JwtokenInfo setAttr(JwtokenInfo recordInfo) {
		checkArgument(recordInfo);
		return setToken(recordInfo);
	}
	
	
	
	private void checkArgument(JwtokenInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.codPlatform == null) {
			logException(new NullPointerException("recordInfo.codPlatform" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.codPlatform" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.codOwner <= 0) {
			logException(new NullPointerException("recordInfo.codOwner" + SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new NullPointerException("recordInfo.codOwner" + SystemMessage.POSITIVE_NUM_EXPECTED);
		}
		
		
		if (recordInfo.username == null) {
			logException(new NullPointerException("recordInfo.username" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.username" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.expirationTime == null) {
			logException(new NullPointerException("recordInfo.expirationTime" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.expirationTime" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.secret == null) {
			logException(new NullPointerException("recordInfo.secret" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.secret" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.algo == null) {
			logException(new NullPointerException("recordInfo.algo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.algo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private JwtokenInfo setToken(JwtokenInfo recordInfo) {
		recordInfo.token = Jwts.builder().claim("codPlatform", recordInfo.codPlatform)	
										 .claim("codOwner", Long.toString(recordInfo.codOwner))			   
										 .claim("username",recordInfo.username)	
										 .setExpiration(recordInfo.expirationTime)				               
										 .signWith(recordInfo.algo, recordInfo.secret)
										 .compact();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
