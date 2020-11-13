package br.com.mind5.business.phoneDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PhonaultCheckRead extends ModelCheckerTemplateSimple<PhonaultInfo> {

	public PhonaultCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonaultInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codLanguage	== null		)		
			
			return super.FAILED;
		
		
		if ( recordInfo.codCustomer <= 0	&&
			 recordInfo.codStore 	<= 0	&& 
			 recordInfo.codUser 	<= 0	&& 
			 recordInfo.codOwnerRef <= 0	&&
			 recordInfo.codEmployee <= 0		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_DEFAULT_MANDATORY_FIELD_EMPTY;
	}
}
