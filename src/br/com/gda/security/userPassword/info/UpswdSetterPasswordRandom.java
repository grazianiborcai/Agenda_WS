package br.com.gda.security.userPassword.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class UpswdSetterPasswordRandom implements InfoSetter<UpswdInfo> {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
    private static final int LENGTH = 8;
	
	
	public UpswdInfo setAttr(UpswdInfo recordInfo) {
		checkArgument(recordInfo);
		return setLength(recordInfo);
	}
	
	
	
	private void checkArgument(UpswdInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.passwordToChange == null) {
			logException(new NullPointerException("recordInfo.passwordToChange" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.passwordToChange" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UpswdInfo setLength(UpswdInfo recordInfo) {
		recordInfo.password = generateRandomPassword();
		return recordInfo;
	}
	
	
	
	private String generateRandomPassword() {
		StringBuilder password = new StringBuilder(LENGTH);
        Random random = new Random(System.nanoTime());
		
        List<String> charCategories = new ArrayList<>(4);
        charCategories.add(LOWER);
        charCategories.add(UPPER);
        charCategories.add(DIGITS);
        charCategories.add(PUNCTUATION);
        
        for (int i = 0; i < LENGTH; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
		
		
        return new String(password);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
