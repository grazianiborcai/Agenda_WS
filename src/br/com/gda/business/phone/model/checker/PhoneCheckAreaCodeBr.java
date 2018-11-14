package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.AreaPhone;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckAreaCodeBr extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckAreaCodeBr() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		int areaCode = getAreaCode(recordInfo.fullNumber);
		
		if (AreaPhone.BR.checkCodArea(areaCode))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private int getAreaCode(String phoneNumber) {
		int begin = 0;
		int end = AreaPhone.BR.getAreaCodeLength();
		String areaCode = phoneNumber.substring(begin, end);
		return Integer.valueOf(areaCode);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_NUMBER_INVALID_AREA_CODE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_NUMBER_INVALID_AREA_CODE;
	}
}
