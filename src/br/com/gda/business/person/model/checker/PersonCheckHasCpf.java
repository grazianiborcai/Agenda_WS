package br.com.gda.business.person.model.checker;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PersonCheckHasCpf extends ModelCheckerTemplateSimple_<PersonInfo> {

	public PersonCheckHasCpf() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.cpf == null )			
			return FAILED;		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PERSON_CPF_BLANK;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_CPF_BLANK;
	}
}
