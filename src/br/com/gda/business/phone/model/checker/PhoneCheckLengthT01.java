package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckLengthT01 extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckLengthT01() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.fullNumber.length() < 10 || recordInfo.fullNumber.length() > 11)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_NUMBER_INVALID_LENGTH_BR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_NUMBER_INVALID_LENGTH_BR;
	}
}
