package br.com.mind5.business.personCustomer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class PersonCusCheckHasCpf extends ModelCheckerTemplateSimple_<PersonCusInfo> {
	
	public PersonCusCheckHasCpf(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonCusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cpf == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PERSON_CUS_CPF_IS_NULL)
			return SystemMessage.PERSON_CUS_CPF_IS_NULL;
		
		return SystemMessage.PERSON_CUS_CPF_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PERSON_CUS_CPF_IS_FILLED;	
			
		return SystemCode.PERSON_CUS_CPF_IS_NULL;
	}
}
