package br.com.mind5.security.userPassword.info;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import br.com.mind5.info.InfoSetterTemplate;

public final class UpswdSetterHash extends InfoSetterTemplate<UpswdInfo> {
	private final int ITERATION = 100;
	
	
	@Override protected UpswdInfo setAttrHook(UpswdInfo recordInfo) {
		recordInfo.hash = generateHash(recordInfo);		
		return recordInfo;
	}
	
	
	
	private byte[] generateHash(UpswdInfo recordInfo) {
		try {
			PBEKeySpec espec = new PBEKeySpec(recordInfo.password.toCharArray(), recordInfo.salt, ITERATION, recordInfo.hashLength * 8);
			SecretKeyFactory secretFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");			
			return secretFactory.generateSecret(espec).getEncoded();	
			
		
		} catch (NoSuchAlgorithmException e) {
			super.logException(e);
			throw new IllegalArgumentException(e);
			
		} catch (InvalidKeySpecException e) {
			super.logException(e);
			throw new IllegalArgumentException(e);
		}
	}
}
