package br.com.mind5.business.person.model.checker;

import java.sql.Connection;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PersonCheckCpfSequence extends ModelCheckerTemplateSimple<PersonInfo> {

	public PersonCheckCpfSequence(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_CPF_INVALID_SEQUENCE;
	}
}
