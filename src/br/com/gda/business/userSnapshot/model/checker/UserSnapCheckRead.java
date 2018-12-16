package br.com.gda.business.userSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class UserSnapCheckRead extends ModelCheckerTemplateSimple<UserSnapInfo> {

	public UserSnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserSnapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 ||
			recordInfo.codSnapshot 	<= 0	)			
			return FAILED;		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
