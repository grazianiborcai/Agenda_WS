package br.com.gda.business.phoneSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneSnapCheckHasSnap extends ModelCheckerTemplateSimple<PhoneSnapInfo> {

	public PhoneSnapCheckHasSnap() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneSnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codSnapshot	<= 0 )				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_SNAPSHOT_IS_NULL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_SNAPSHOT_IS_NULL;
	}
}
