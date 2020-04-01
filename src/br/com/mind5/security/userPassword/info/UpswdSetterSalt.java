package br.com.mind5.security.userPassword.info;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UpswdSetterSalt implements InfoSetter<UpswdInfo> {
	
	public UpswdInfo setAttr(UpswdInfo recordInfo) {
		checkArgument(recordInfo);
		return setRandomSalt(recordInfo);
	}
	
	
	
	private void checkArgument(UpswdInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		
		if (recordInfo.hashLength <= 0) {
			logException(new NullPointerException("recordInfo.hashLength" + SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new NullPointerException("recordInfo.hashLength" + SystemMessage.POSITIVE_NUM_EXPECTED);
		}
	}
	
	
	
	private UpswdInfo setRandomSalt(UpswdInfo recordInfo) {
		Random random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			recordInfo.salt = new byte[recordInfo.hashLength];
			random.nextBytes(recordInfo.salt);
			return recordInfo;
		
		} catch (NoSuchAlgorithmException e) {
			logException(e);
			throw new IllegalArgumentException(e);
		}
	}

		
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
