package br.com.mind5.business.phone.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckNumberT01 extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckNumberT01(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_NUMBER_IS_VALID;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_NUMBER_INVALID;
	}	
}
