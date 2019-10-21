package br.com.mind5.business.personUser_.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class PersonUserCheckRef extends ModelCheckerTemplateSimple_<PersonUserInfo> {

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
