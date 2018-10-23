package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.AreaPhone;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckBrSequence extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckBrSequence() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if (checkSequence(recordInfo.phoneNumber))			
			return super.SUCCESS;
		
		
		return super.FAILED;
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
		return SystemMessage.PHONE_NUMBER_INVALID_SEQUENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_NUMBER_INVALID_SEQUENCE;
	}
}
