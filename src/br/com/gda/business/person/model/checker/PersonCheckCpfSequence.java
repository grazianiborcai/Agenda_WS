package br.com.gda.business.person.model.checker;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PersonCheckCpfSequence extends ModelCheckerTemplateSimple<PersonInfo> {

	public PersonCheckCpfSequence() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cpf == null)
			return super.FAILED;
		
		
		if (checkSequence(recordInfo.cpf))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private boolean checkSequence(String cpf) {
		boolean IS_MONODIGIT = true;
		
		if (cpf.matches("^(\\d)\\1+$") == IS_MONODIGIT) 
			return FAILED;		
	    
	    return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PERSON_CPF_INVALID_SEQUENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_CPF_INVALID_SEQUENCE;
	}
}
