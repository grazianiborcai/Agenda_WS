package br.com.gda.business.userSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class UserSnapCheckHasAddress extends ModelCheckerTemplateSimple<UserSnapInfo> {

	public UserSnapCheckHasAddress() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserSnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.addresses == null || 
			 recordInfo.addresses.isEmpty()		)				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_SNAPSHOT_NO_ADDRESS;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_SNAPSHOT_NO_ADDRESS;
	}
}
