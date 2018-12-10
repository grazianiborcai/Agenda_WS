package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckRefMulti extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckRefMulti() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		int totRef = 0;
		
		if ( recordInfo.codCustomer >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codStore >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codEmployee >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codUser >= 0 )
			totRef = totRef + 1;	
				
		if ( totRef != 1 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_MULTIPLE_REFERENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_MULTIPLE_REFERENCE;
	}
}
