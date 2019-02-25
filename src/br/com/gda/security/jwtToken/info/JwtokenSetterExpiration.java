package br.com.gda.security.jwtToken.info;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class JwtokenSetterExpiration implements InfoSetter<JwtokenInfo> {
	private final int MINUTE = 60000;
	private final int HOUR = MINUTE * 60;
	private final long EXPIRATION_TIME = HOUR * 4;
	
	
	public JwtokenInfo setAttr(JwtokenInfo recordInfo) {
		checkArgument(recordInfo);
		return setExpiration(recordInfo);
	}
	
	
	
	private void checkArgument(JwtokenInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private JwtokenInfo setExpiration(JwtokenInfo recordInfo) {
		Date now = DefaultValue.dateNow();		
		recordInfo.expirationTime = new Date(now.getTime() + EXPIRATION_TIME);
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
