package br.com.mind5.security.otp.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.mind5.info.InfoSetterTemplate;

public final class OtpSetterRandom extends InfoSetterTemplate<OtpInfo> {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final int LENGTH = 6;
	
	
    @Override protected OtpInfo setAttrHook(OtpInfo recordInfo) {
		recordInfo.password = generateRandomPassword();
		return recordInfo;
	}
	
	
	
	private String generateRandomPassword() {
		StringBuilder password = new StringBuilder(LENGTH);
        Random random = new Random(System.nanoTime());
		
        List<String> charCategories = new ArrayList<>(4);
        charCategories.add(UPPER);
        charCategories.add(DIGITS);
        
        for (int i = 0; i < LENGTH; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
		
		
        return new String(password);
	}
}
