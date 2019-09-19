package br.com.gda.business.personUser_.model.checker;

import java.sql.Connection;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PersonUserCheckHasEmail extends ModelCheckerTemplateSimple_<PersonUserInfo> {
	
	public PersonUserCheckHasEmail(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonUserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.email == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PERSON_USER_EMAIL_IS_NULL)
			return SystemMessage.PERSON_USER_EMAIL_IS_NULL;
		
		return SystemMessage.PERSON_USER_EMAIL_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PERSON_USER_EMAIL_IS_FILLED;	
			
		return SystemCode.PERSON_USER_EMAIL_IS_NULL;
	}
}
