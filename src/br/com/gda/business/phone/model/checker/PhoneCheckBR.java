package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.AreaPhone;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckBR extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckBR() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if (checkNull(recordInfo.phoneNumber) == super.FAILED)
			return super.FAILED;
		
		if (checkOnlyNumber(recordInfo.phoneNumber) == super.FAILED)			
			return super.FAILED;
		
		if (checkLength(recordInfo.phoneNumber) == super.FAILED)			
			return super.FAILED;
		
		if (checkAreaCode(recordInfo.phoneNumber) == super.FAILED)			
			return super.FAILED;
		
		if (checkPhoneNumber(recordInfo.phoneNumber) == super.FAILED)
			return super.FAILED;
		
		if (checkSequence(recordInfo.phoneNumber) == FAILED)			
			return FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkNull(String phoneNumber) {
		if (phoneNumber == null)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkOnlyNumber(String phoneNumber) {
	    return phoneNumber.matches("^\\d+$");
	}
	
	
	
	private boolean checkLength(String phoneNumber) {
	    if (phoneNumber.length() < 10 || phoneNumber.length() > 11)
	           return super.FAILED;
	    
	    return super.SUCCESS;
	}
	
	
	
	private boolean checkAreaCode(String phoneNumber) {
		int areaCode = getAreaCode(phoneNumber);
		return AreaPhone.BR.checkCodArea(areaCode);
	}
	
	
	
	private int getAreaCode(String phoneNumber) {
		int begin = 0;
		int end = AreaPhone.BR.getAreaCodeLength();
		String areaCode = phoneNumber.substring(begin, end);
		return Integer.valueOf(areaCode);
	}
	
	
	
	private boolean checkPhoneNumber(String phoneNumber) {
		if (isMobile(phoneNumber))
			return checkMobileNumber(phoneNumber);
	    
	    return checkLandLineNumber(phoneNumber);
	}
	
	
	
	private boolean isMobile(String phoneNumber) {
		int begin = AreaPhone.BR.getAreaCodeLength();
		int end = begin + 1;
		
		String firstDigit = phoneNumber.substring(begin, end);
		return firstDigit.equals("9");
	}
	
	
	
	private boolean checkMobileNumber(String phoneNumber) {
		if (checkMobileLength(phoneNumber) == super.FAILED)
			return super.FAILED;
		
		return true;
	}
	
	
	
	private boolean checkMobileLength(String phoneNumber) {
	    if (phoneNumber.length() != 11)
	           return super.FAILED;
	    
	    return super.SUCCESS;
	}
	
	
	
	private boolean checkLandLineNumber(String phoneNumber) {
		if (checkLandLineLength(phoneNumber) == super.FAILED)
			return super.FAILED;
		
		return true;
	}
	
	
	
	private boolean checkLandLineLength(String phoneNumber) {
	    if (phoneNumber.length() != 10)
	           return super.FAILED;
	    
	    return super.SUCCESS;
	}
	
	
	
	private boolean checkSequence(String phoneNumber) {
		boolean IS_MONODIGIT = true;
		String number = removeAreaCode(phoneNumber);
		
		if (number.matches("^(\\d)\\1+$") == IS_MONODIGIT) 
			return FAILED;		
	    
	    return SUCCESS;
	}
	
	
	
	private String removeAreaCode(String phoneNumber) {
		int begin = AreaPhone.BR.getAreaCodeLength();
		int end = phoneNumber.length();
		
		return phoneNumber.substring(begin, end);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_NUMBER_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_NUMBER_INVALID;
	}
}
