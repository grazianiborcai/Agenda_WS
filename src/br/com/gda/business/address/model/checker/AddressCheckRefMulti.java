package br.com.gda.business.address.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class AddressCheckRefMulti extends ModelCheckerTemplateSimple<AddressInfo> {

	public AddressCheckRefMulti() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {	
		int totRef = 0;
		
		if ( recordInfo.codCustomer >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codStore >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codEmployee >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codUser >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codPayCustomer >= 0 )
			totRef = totRef + 1;
		
		if ( recordInfo.codOwnerRef >= 0 )
			totRef = totRef + 1;
				
		if ( totRef != 1 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ADDRESS_MULTIPLE_REFERENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ADDRESS_MULTIPLE_REFERENCE;
	}
}
