package br.com.gda.business.addressSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class AddresnapCheckHasSnap_ extends ModelCheckerTemplateSimple<AddresnapInfo> {

	public AddresnapCheckHasSnap_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AddresnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codSnapshot	<= 0 )				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ADDRESS_SNAPSHOT_IS_NULL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ADDRESS_SNAPSHOT_IS_NULL;
	}
}
