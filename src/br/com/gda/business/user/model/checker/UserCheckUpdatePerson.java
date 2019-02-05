package br.com.gda.business.user.model.checker;

import java.sql.Connection;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class UserCheckUpdatePerson extends ModelCheckerTemplateSimple<UserInfo> {
	
	public UserCheckUpdatePerson() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.personData == null)			
			return super.FAILED;		
		
		if (recordInfo.personData.codOwner  != recordInfo.codOwner	||
			recordInfo.personData.codPerson != recordInfo.codPerson		)			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.PERSON_MISMATCH;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_MISMATCH;
	}
}
