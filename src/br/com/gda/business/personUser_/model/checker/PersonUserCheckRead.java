package br.com.gda.business.personUser_.model.checker;

import java.sql.Connection;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PersonUserCheckRead extends ModelCheckerTemplateSimple_<PersonUserInfo> {

	public PersonUserCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonUserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 )			
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
