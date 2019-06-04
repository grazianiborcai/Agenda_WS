package br.com.gda.business.addressSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class AddresnapCheckRead extends ModelCheckerTemplateSimple<AddresnapInfo> {

	public AddresnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AddresnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner <= 0 )		
			return super.FAILED;
		
		
		if ( recordInfo.codSnapshot 		<= 0 &&
			 recordInfo.codCustomerSnapshot	<= 0 &&
			 recordInfo.codEmployeeSnapshot	<= 0 &&
			 recordInfo.codOwnerRefSnapshot	<= 0 &&
			 recordInfo.codStoreSnapshot	<= 0 &&
			 recordInfo.codUserSnapshot		<= 0	)
			
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
