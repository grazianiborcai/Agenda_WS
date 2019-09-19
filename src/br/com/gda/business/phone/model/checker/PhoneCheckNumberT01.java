package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PhoneCheckNumberT01 extends ModelCheckerTemplateSimple_<PhoneInfo> {

	public PhoneCheckNumberT01() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.number == null)
			return super.FAILED;		
		
		
		return (checkPhoneNumber(recordInfo.number));
	}
	
	
	
	private boolean checkPhoneNumber(String phoneNumber) {
		if (isMobile(phoneNumber))
			return checkMobile(phoneNumber);
	    
	    return checkLandline(phoneNumber);
	}
	
	
	
	private boolean isMobile(String phoneNumber) {
		int begin = 0;
		int end = begin + 1;
		
		String firstDigit = phoneNumber.substring(begin, end);
		return firstDigit.equals("9");
	}
	
	
	
	private boolean checkMobile(String phoneNumber) {
		if (checkMobileLength(phoneNumber) == super.FAILED)
			return super.FAILED;
		
		return true;
	}
	
	
	
	private boolean checkMobileLength(String phoneNumber) {
	    if (phoneNumber.length() != 9)
	           return super.FAILED;
	    
	    return super.SUCCESS;
	}
	
	
	
	private boolean checkLandline(String phoneNumber) {
		if (checkLandLineLength(phoneNumber) == super.FAILED)
			return super.FAILED;
		
		return true;
	}
	
	
	
	private boolean checkLandLineLength(String phoneNumber) {
	    if (phoneNumber.length() != 8)
	           return super.FAILED;
	    
	    return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_NUMBER_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_NUMBER_INVALID;
	}
}
