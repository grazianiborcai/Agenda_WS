package br.com.mind5.business.address.model.checker;

import java.sql.Connection;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class AddressCheckRefMulti extends ModelCheckerTemplateSimpleV2<AddressInfo> {

	public AddressCheckRefMulti(ModelCheckerOption option) {
		super(option);
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
		
		if ( recordInfo.codOwnerRef >= 0 )
			totRef = totRef + 1;
				
		if ( totRef != 1 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_MULTIPLE_REFERENCE;
	}
}
