package br.com.mind5.security.otp.info;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import br.com.mind5.info.InfoSetterTemplate;

public final class OtpSetterHashToMatch extends InfoSetterTemplate<OtpInfo> {
	private final int ITERATION = 100;
	
	
	@Override protected OtpInfo setAttrHook(OtpInfo recordInfo) {
		recordInfo.hashToMatch = generateHash(recordInfo);		
		return recordInfo;
	}
	
	
	
	private byte[] generateHash(OtpInfo recordInfo) {
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
