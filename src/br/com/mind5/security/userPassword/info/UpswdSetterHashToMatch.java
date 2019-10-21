package br.com.mind5.security.userPassword.info;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UpswdSetterHashToMatch implements InfoSetter<UpswdInfo> {
	private final int ITERATION = 100;
	
	public UpswdInfo setAttr(UpswdInfo recordInfo) {
		checkArgument(recordInfo);
		return setHash(recordInfo);
	}
	
	
	
	private void checkArgument(UpswdInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.password == null) {
			logException(new NullPointerException("recordInfo.password" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.password" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
		if (recordInfo.salt == null) {
			logException(new NullPointerException("recordInfo.salt" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.salt" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.salt.length == 0) {
			logException(new NullPointerException("recordInfo.salt" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfo.salt" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		if (recordInfo.hashLength <= 0) {
			logException(new NullPointerException("recordInfo.hashLength" + SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new NullPointerException("recordInfo.hashLength" + SystemMessage.POSITIVE_NUM_EXPECTED);
		}
	}
	
	
	
	private UpswdInfo setHash(UpswdInfo recordInfo) {
		recordInfo.hashToMatch = generateHash(recordInfo);		
		return recordInfo;
	}
	
	
	
	private byte[] generateHash(UpswdInfo recordInfo) {
		try {
			PBEKeySpec espec = new PBEKeySpec(recordInfo.password.toCharArray(), recordInfo.salt, ITERATION, recordInfo.hashLength * 8);
			SecretKeyFactory secretFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");			
			return secretFactory.generateSecret(espec).getEncoded();	
			
		
		} catch (NoSuchAlgorithmException e) {
			logException(e);
			throw new IllegalArgumentException(e);
			
		} catch (InvalidKeySpecException e) {
			logException(e);
			throw new IllegalArgumentException(e);
		}
	}

		
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
