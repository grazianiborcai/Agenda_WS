package br.com.mind5.business.phone.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckRefWrite extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckRefWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCustomer 	<= 0	&&
			 recordInfo.codStore 		<= 0	&& 
			 recordInfo.codUser 		<= 0	&&
			 recordInfo.codLegalPerson 	<= 0	&&
			 recordInfo.codOwnerRef 	<= 0	&& 
			 recordInfo.codEmployee 	<= 0		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_NUMBER_IS_VALID;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_WITHOUT_REFERENCE;
	}
}
