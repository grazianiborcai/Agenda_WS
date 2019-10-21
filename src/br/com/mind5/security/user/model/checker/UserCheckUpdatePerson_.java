package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckUpdatePerson_ extends ModelCheckerTemplateSimple_<UserInfo> {
	
	public UserCheckUpdatePerson_() {
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
