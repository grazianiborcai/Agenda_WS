package br.com.gda.business.person.model.checker;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PersonCheckHasEmail extends ModelCheckerTemplateSimple_<PersonInfo> {

	public PersonCheckHasEmail() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.email == null )			
			return FAILED;		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PERSON_EMAIL_BLANK;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_EMAIL_BLANK;
	}
}
