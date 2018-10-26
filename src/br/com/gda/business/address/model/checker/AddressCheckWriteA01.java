package br.com.gda.business.address.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class AddressCheckWriteA01 extends ModelCheckerTemplateSimple<AddressInfo> {

	public AddressCheckWriteA01() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.codCountry 		== null ||
			 recordInfo.codState 		== null ||
			 recordInfo.city 			== null || 
			 recordInfo.district 		== null || 
			 recordInfo.street 			== null || 
			 recordInfo.streetNumber 	== null || 
			 recordInfo.postalCode 		== null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
