package br.com.mind5.security.jwtToken.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class JwtokenSetterSecret implements InfoSetter<JwtokenInfo> {
	private final String SECRET_KEY = "t8%A$?Cx>u?px^'<XfSGn3&w~6OEYu/M5}${Un>Xgto7#}Lt6ZgaQGQ#_V(y{j$";
	
	
	public JwtokenInfo setAttr(JwtokenInfo recordInfo) {
		checkArgument(recordInfo);
		return setSecret(recordInfo);
	}
	
	
	
	private void checkArgument(JwtokenInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private JwtokenInfo setSecret(JwtokenInfo recordInfo) {
		recordInfo.secret = SECRET_KEY;
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
