package br.com.gda.business.personUser_.model.checker;

import java.sql.Connection;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PersonUserCheckRef extends ModelCheckerTemplateSimple<PersonUserInfo> {

	public PersonUserCheckRef() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonUserInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.email == null	&&
			 recordInfo.cpf	  == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PERSON_USER_WITHOUT_REFERENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_USER_WITHOUT_REFERENCE;
	}
}
