package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PhoneCheckRefWrite extends ModelCheckerTemplateSimple_<PhoneInfo> {

	public PhoneCheckRefWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCustomer 	<= 0	&&
			 recordInfo.codStore 		<= 0	&& 
			 recordInfo.codUser 		<= 0	&& 
			 recordInfo.codOwnerRef 	<= 0	&& 
			 recordInfo.codEmployee 	<= 0		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_WITHOUT_REFERENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_WITHOUT_REFERENCE;
	}
}
