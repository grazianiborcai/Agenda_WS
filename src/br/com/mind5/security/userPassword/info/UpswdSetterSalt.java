package br.com.mind5.security.userPassword.info;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import br.com.mind5.info.InfoSetterTemplate;

public final class UpswdSetterSalt extends InfoSetterTemplate<UpswdInfo> {
	
	@Override protected UpswdInfo setAttrHook(UpswdInfo recordInfo) {
		Random random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			recordInfo.salt = new byte[recordInfo.hashLength];
			random.nextBytes(recordInfo.salt);
			return recordInfo;
		
		} catch (NoSuchAlgorithmException e) {
			super.logException(e);
			throw new IllegalArgumentException(e);
		}
	}
}
