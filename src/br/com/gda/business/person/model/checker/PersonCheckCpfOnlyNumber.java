package br.com.gda.business.person.model.checker;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PersonCheckCpfOnlyNumber extends ModelCheckerTemplateSimpleV2<PersonInfo> {

	public PersonCheckCpfOnlyNumber(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cpf == null)			
			return super.FAILED;		
		
		
		if (recordInfo.cpf.matches("^\\d+$"))			
			return super.SUCCESS;		
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_CPF_INVALID_NUMBER;
	}
}
