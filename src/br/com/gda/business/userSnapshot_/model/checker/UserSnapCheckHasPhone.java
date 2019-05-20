package br.com.gda.business.userSnapshot_.model.checker;

import java.sql.Connection;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class UserSnapCheckHasPhone extends ModelCheckerTemplateSimple<UserSnapInfo> {

	public UserSnapCheckHasPhone() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserSnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.phones == null 		|| 
			 recordInfo.phones.isEmpty()		)				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_SNAPSHOT_NO_PHONE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_SNAPSHOT_NO_PHONE;
	}
}
