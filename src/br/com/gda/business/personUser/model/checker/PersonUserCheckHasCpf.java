package br.com.gda.business.personUser.model.checker;

import java.sql.Connection;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PersonUserCheckHasCpf extends ModelCheckerTemplateSimple<PersonUserInfo> {
	
	public PersonUserCheckHasCpf(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonUserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cpf == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PERSON_USER_CPF_IS_NULL)
			return SystemMessage.PERSON_USER_CPF_IS_NULL;
		
		return SystemMessage.PERSON_USER_CPF_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PERSON_USER_CPF_IS_FILLED;	
			
		return SystemCode.PERSON_USER_CPF_IS_NULL;
	}
}
