package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhoneCheckRefMulti extends ModelCheckerTemplateSimpleV2<PhoneInfo> {

	public PhoneCheckRefMulti(ModelCheckerOption option) {
		super(option);
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
		
		if ( recordInfo.codOwnerRef >= 0 )
			totRef = totRef + 1;
				
		if ( totRef != 1 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_NUMBER_IS_VALID;
	}		
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_MULTIPLE_REFERENCE;
	}
}
